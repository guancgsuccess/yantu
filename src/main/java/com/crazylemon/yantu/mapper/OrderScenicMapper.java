package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.OrderScenic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.crazylemon.yantu.entity.Scenic;

import com.crazylemon.yantu.enums.OrderStatusEnums;

import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

import java.util.List;

/**

 - <p>
 - Mapper 接口  订单和景点的关联表---一对多
 - </p>
 *
 - @author wangzh
 - @since 2018-10-09
 */
public interface OrderScenicMapper extends BaseMapper<OrderScenic> {

    /**
     * 保存关联表信息到数据库
     * @param orderScenic
     * @return
     */
    @Insert("insert into order_scenic(scenic_id,order_id,order_scenic_num) values (#{scenicId},#{orderId},#{orderScenicNum})")
    Integer saveOrderScenic(OrderScenic orderScenic);

    /**
     * 通过订单Id,查询订单中景点集合
     * @param orderId
     * @return 景点集合
     */
    @Select("select * from order_scenic where order_id = #{orderId}")
    List<OrderScenic> getOrderScenicByOrderId(@Param("orderId") Integer orderId);
    /**
     * 通过订单Id,查询订单中景点的id.
     * @param orderId
     * @return 景点Id集合
     */
    @Select("select scenic_id from order_scenic where order_id = #{orderId}")
    List<Integer> getScenicIdList(@Param("orderId") Integer orderId);

    /**
     * 根据订单ID  同步修改 关联表的Id  : 订单失效则关联表字段失效 在订单失效Service中调用
     * @param orderId
     * @return 受影响行数
     */
    @Update("update order_scenic set order_scenic_status = 0 where order_id  = #{id}")
    Integer setStatusLoseById(@Param("id") Integer orderId);

}
