package com.crazylemon.yantu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.entity.OrderMaster;
import com.crazylemon.yantu.utils.OrderInfoUtil;
import com.crazylemon.yantu.vo.OrderVO;
import com.crazylemon.yantu.vo.ServiceResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-17
 */
public interface IOrderMasterService extends IService<OrderMaster> {

    /**
     * 添加订单主表
     * @param orderInfoUtil 订单视图对象
     * @return 受影响行数
     */
    ServiceResult<Integer> saveOrderMaster(OrderInfoUtil orderInfoUtil);

    /**
     * 通过ID查询订单对象
     * @param orderId
     * @return
     */
    ServiceResult<OrderVO> getOrderById(Integer orderId);

    /**
     * 修改订单状态为已完成
     * @param orderId
     * @return
     */
    ServiceResult<Integer> updateOrderStatusToSuccess(Integer orderId);

    /**
     * 修改订单状态为已完成
     * @param orderId
     * @return
     */
    ServiceResult<Integer> updateOrderStatusToCancel(Integer orderId);

    /**
     * 根据用户Id查询用户订单
     * @param visitorId
     * @return
     */
    ServiceResult<List<OrderVO>> getOrderByVisitorId(Integer visitorId);

    /**
     * 分页查询当前页码
     * @param currentPage 当前页码
     * @return 分页对象
     */
    ServiceResult<IPage<OrderMaster>> listOrderByPage(Integer currentPage, Integer visitorId);
}
