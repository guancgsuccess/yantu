package com.crazylemon.yantu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.entity.OrderScenic;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface IOrderScenicService extends IService<OrderScenic> {

    Integer saveOrderScenic(OrderScenic orderScenic);

    List<OrderScenic> getOrderScenicByOrderId(Integer orderId);

    List<Integer> getScenicIdList(Integer orderId);

    Integer setStatusLoseById(Integer orderId);

}
