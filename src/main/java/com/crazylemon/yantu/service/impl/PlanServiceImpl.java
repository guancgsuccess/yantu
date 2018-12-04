package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.mapper.PlanMapper;
import com.crazylemon.yantu.service.IPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.utils.PageModel;
import com.crazylemon.yantu.utils.ResponseCode;
import com.crazylemon.yantu.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
@CacheConfig(cacheNames = "plan")
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements IPlanService {

    private final PlanMapper planMapper;

    @Autowired
    public PlanServiceImpl(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    @Cacheable
    public ServerResponse getPlanById(Integer planId) {
        Plan plan = planMapper.getById(planId);
        if(plan != null){
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),plan,"查询成功!");
        }else {
            return new ServerResponse(ResponseCode.ERROR.getCode(),"查询失败!");
        }
    }

    @Override
    public Plan getById(Integer planId){
        return planMapper.selectById(planId);
    }

    @Override
    @Cacheable
    public ServerResponse getAll(Integer pageCode) {
        PageModel<Plan> page = new PageModel<>();
        System.out.println("pagecode=" + pageCode);
        if(pageCode == null){//首页
            page.setCurrentPageCode(1);
        }else{
            page.setCurrentPageCode(pageCode);
        }
        page.setTotalRecord(planMapper.getCount());
        page.setTotalPages(page.getTotalRecord()%page.getPageSize() ==0?page.getTotalRecord()/page.getPageSize() :page.getTotalRecord()/page.getPageSize() +1);
        page.setStartRecord((page.getCurrentPageCode()-1) * page.getPageSize());

        PageModel<Plan> pageModel = new PageModel<>();
        pageModel.setStartRecord(page.getStartRecord());

        page.setModelList(planMapper.getAll(pageModel));

        System.out.println(page);
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),page,"查询成功");
    }
}
