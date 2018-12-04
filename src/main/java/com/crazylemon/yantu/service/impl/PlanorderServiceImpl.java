package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Planorder;

import com.crazylemon.yantu.enums.OrderStatusEnums;

import com.crazylemon.yantu.mapper.OrderMasterMapper;

import com.crazylemon.yantu.mapper.PlanorderMapper;

import com.crazylemon.yantu.service.IPlanorderService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**

 - <p>
 - 服务实现类
 - </p>
 *
 - @author wangzh
 - @since 2018-10-09
 */
@Service
public class PlanorderServiceImpl extends ServiceImpl<PlanorderMapper, Planorder> implements IPlanorderService {
    @Resource
    private PlanorderMapper planorderMapper;
    @Resource
    private OrderMasterMapper orderMasterMapper;
    @Override
    public List<Integer> getPlanIdList(Integer orderId) {
        return planorderMapper.getPlanIdList(orderId);
    }
    @Override
    public Integer setStatusLoseById(Integer orderId) {
        if (null != orderId) {
            Integer orderStatus = orderMasterMapper.selectById(orderId).getOrderStatus();
            //订单状态为已取消状态,则设置关联表状态为取消状态
            if(orderStatus.equals(OrderStatusEnums.CANCEL.getCode())){
                return planorderMapper.setStatusLoseById(orderId);
            }
        }
        return 0;
    }
}
