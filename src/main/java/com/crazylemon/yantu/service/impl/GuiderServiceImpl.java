package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Guider;
import com.crazylemon.yantu.mapper.GuiderMapper;
import com.crazylemon.yantu.service.IGuiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.utils.PageModel;
import com.crazylemon.yantu.utils.ResponseCode;
import com.crazylemon.yantu.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GuiderServiceImpl extends ServiceImpl<GuiderMapper, Guider> implements IGuiderService {


    private final GuiderMapper guiderMapper;

    @Autowired
    public GuiderServiceImpl(GuiderMapper guiderMapper) {
        this.guiderMapper = guiderMapper;
    }

    /**
     * 6 分页查询 导游信息
     *
     * @param currentPageCode 当前页码
     * @return
     */
    @Override
    public ServerResponse getGuiderBypage(Integer currentPageCode) {

        PageModel<Guider> guiderPageModel = new PageModel<>();
        List<Guider> guiderList = null;
//        每页显示记录数
        Integer pagesize = guiderPageModel.getPageSize();
//        获取当前页
        guiderPageModel.setCurrentPageCode(currentPageCode);
//        从第几条数据开始
        guiderPageModel.setStartRecord(((currentPageCode - 1) * pagesize));
        System.out.println("第 :" + guiderPageModel.getStartRecord() + "条开始");
//        总记录数
        guiderPageModel.setTotalRecord(guiderMapper.getCount());
//       总页数
        Integer totalPage = guiderPageModel.getTotalRecord() % guiderPageModel.getPageSize() == 0 ? guiderPageModel.getTotalRecord() / guiderPageModel.getPageSize() :
        guiderPageModel.getTotalRecord() / guiderPageModel.getPageSize() + 1;
        guiderPageModel.setTotalPages(totalPage);
        //根据当前页码查询 guiderList
        guiderList = guiderMapper.getGuiderBypage(guiderPageModel);
        if (guiderList == null) {
            return new ServerResponse(ResponseCode.ERROR.getCode(),"查询失败!");
        } else {
            guiderPageModel.setModelList(guiderList);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),guiderPageModel,"查询成功!");
        }

    }

}
