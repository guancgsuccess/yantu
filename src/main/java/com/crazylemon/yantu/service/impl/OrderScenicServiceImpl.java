package com.crazylemon.yantu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazylemon.yantu.entity.OrderScenic;
import com.crazylemon.yantu.entity.Tourist;
import com.crazylemon.yantu.enums.OrderStatusEnums;
import com.crazylemon.yantu.enums.ScenicStatusEnums;
import com.crazylemon.yantu.mapper.OrderMasterMapper;
import com.crazylemon.yantu.mapper.OrderScenicMapper;
import com.crazylemon.yantu.mapper.TouristMapper;
import com.crazylemon.yantu.service.IOrderScenicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class OrderScenicServiceImpl extends ServiceImpl<OrderScenicMapper, OrderScenic> implements IOrderScenicService {
    @Resource
    private TouristMapper touristMapper;

    @Resource
    private OrderScenicMapper orderScenicMapper;

    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Override
    @Transactional
    public Integer saveOrderScenic(OrderScenic orderScenic) {
        if (null != orderScenic) {
            //默认状态为1
            orderScenic.setOrderScenicStatus(ScenicStatusEnums.CREATE.getCode());

            //数量根据Visitor数量确定

            List<Tourist> visitorList = touristMapper.selectList(new QueryWrapper<Tourist>().eq("order_id", orderScenic.getOrderId()));

            System.out.println("visitorList:" + visitorList);

            //封装数量到OrderScenic中
            orderScenic.setOrderScenicNum(visitorList.size());

            return orderScenicMapper.saveOrderScenic(orderScenic);

        }

        return 0;

    }

    @Override

    public List<OrderScenic> getOrderScenicByOrderId(Integer orderId) {

        return orderScenicMapper.getOrderScenicByOrderId(orderId);

    }

    @Override

    public List<Integer> getScenicIdList(Integer orderId) {

        return orderScenicMapper.getScenicIdList(orderId);

    }

    @Override

    @Transactional

    public Integer setStatusLoseById(Integer orderId) {

        if (null != orderId) {

            Integer orderStatus = orderMasterMapper.selectById(orderId).getOrderStatus();

            //订单状态为已取消状态,则设置关联表状态为取消状态

            if(orderStatus.equals(OrderStatusEnums.CANCEL.getCode())){

                return orderScenicMapper.setStatusLoseById(orderId);

            }

        }

        return 0;

    }

}
