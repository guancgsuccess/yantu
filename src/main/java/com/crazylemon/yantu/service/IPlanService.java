package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Plan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.utils.ServerResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IPlanService extends IService<Plan> {
    ServerResponse getPlanById(Integer planId);
    ServerResponse getAll(Integer pageCode);
    Plan getById(Integer planId);

}
