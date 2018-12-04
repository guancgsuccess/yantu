package com.crazylemon.yantu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazylemon.yantu.entity.OrderMaster;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-17
 */
@Repository
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {


    /**
     * 保存订单信息到数据库,并返回主键值给对象orderMaster
     * @param orderMaster
     * @return
     */
    @Insert("INSERT INTO order_master(order_days,order_createtime,order_insurance,order_num,order_price,visitor_id) VALUES(#{orderDays},#{orderCreatetime},#{orderInsurance},#{orderNum},#{orderPrice},#{visitorId})")
    @Options(useGeneratedKeys=true, keyProperty = "orderId",keyColumn="order_id")
    Integer saveOrder(OrderMaster orderMaster);

    /**
     * 根据游客ID查询该用户的订单信息
     * @param visitorId
     * @return
     */
    @Select("select * from order_master where visitor_id = #{visitorId}")
    List<OrderMaster> getByVisitorId(@Param("visitorId") Integer visitorId);

    /**
     * 根据订单id查询订单信息
     * @param orderId
     * @return
     */
    @Select("select * from order_master where order_id = #{id}")
    OrderMaster getById(@Param("id") Integer orderId);

    /**
     *  根据ID修改订单状态
     */
    @Update("update order_master set order_status = #{status} where order_id = #{id}")
    Integer updateOrderStatus(@Param("status") Integer status, @Param("id") Integer id);
}
