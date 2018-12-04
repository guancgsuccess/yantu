package com.crazylemon.yantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.entity.Scenic;
import com.crazylemon.yantu.entity.ScenicPhoto;
import com.crazylemon.yantu.mapper.ScenicMapper;
import com.crazylemon.yantu.mapper.ScenicPhotoMapper;
import com.crazylemon.yantu.service.IScenicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.utils.PageModel;
import com.crazylemon.yantu.utils.ResponseCode;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScenicVO;
import com.crazylemon.yantu.vo.ServiceResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Service
@CacheConfig(cacheNames = "scenic")
public class ScenicServiceImpl extends ServiceImpl<ScenicMapper, Scenic> implements IScenicService {

    private final ScenicMapper scenicMapper;
    @Autowired
    public ScenicServiceImpl(ScenicMapper scenicMapper) {
        this.scenicMapper = scenicMapper;
    }

    @Resource
    private ScenicPhotoMapper scenicPhotoMapper;
    @Override
    public ServerResponse getById(Integer scenicId) {
        Scenic scenic = scenicMapper.getById(scenicId);
        if(scenic != null){
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),scenic,"查询成功!");
        }else {
            return new ServerResponse(ResponseCode.ERROR.getCode(),"查询失败!");
        }
    }

    @Override
    @Cacheable
    public ServerResponse getAll(Integer pageCode) {
        PageModel<Scenic> page = new PageModel<>();
        System.out.println("pagecode=" + pageCode);
        if(pageCode == null){//首页
            page.setCurrentPageCode(1);
        }else{
            page.setCurrentPageCode(pageCode);
        }
        page.setTotalRecord(scenicMapper.getCount());
        page.setTotalPages(page.getTotalRecord()%page.getPageSize() ==0?page.getTotalRecord()/page.getPageSize() :page.getTotalRecord()/page.getPageSize() +1);
        page.setStartRecord((page.getCurrentPageCode()-1) * page.getPageSize());

        PageModel<Scenic> pageModel = new PageModel<>();
        pageModel.setStartRecord(page.getStartRecord());

        page.setModelList(scenicMapper.getAll(pageModel));

        return new ServerResponse(ResponseCode.SUCCESS.getCode(),page,"查询成功");

    }

    @Override
    public List<String> selectByName(String name) {
        return scenicMapper.selectByName(name);
    }

    @Override
    public ServiceResult<ScenicVO> getScenicById(Integer scenicId) {

        Scenic scenic = scenicMapper.selectById(scenicId);
        if (null == scenic){
            return ServiceResult.createByError("查询失败,景点不存在");
        }
        ScenicVO scenicVO = new ScenicVO();
        BeanUtils.copyProperties(scenic,scenicVO);
//        scenicVO.setScenicNum(orderScenic.getOrderScenicNum());
        scenicVO.setScenicPhotoList(scenicPhotoMapper.selectList(new QueryWrapper<ScenicPhoto>()
                        .eq("scenic_id",scenic.getScenicId())
                        .eq("photo_status",1)
                )

        );

        return ServiceResult.createByCheckSuccess("成功",scenicVO);

    }

    @Override
    public ServerResponse getByName(String name) {
        Scenic scenic = scenicMapper.getByName(name);
        if(scenic != null){
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),scenic,"查看成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"查看失败!");
    }


}
