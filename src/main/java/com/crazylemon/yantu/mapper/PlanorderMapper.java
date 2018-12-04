package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Planorder;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

import java.util.List;

/**

 - <p>
 - Mapper 接口
 - </p>
 *
 - @author wangzh
 - @since 2018-10-09
 */
public interface PlanorderMapper extends BaseMapper<Planorder> {

    /**
     * 返回计划ID集合
     * @param orderId
     * @return
     */
    @Select("select plan_id from planorder where order_id = #{orderId}")
    List<Integer> getPlanIdList(@Param("orderId") Integer orderId);

    /**
     * 根据订单ID  同步修改 关联表的Id  : 订单失效则关联表字段失效 在订单失效Service中调用
     * @param orderId
     * @return 受影响行数
     */
    @Update("update planorder set order_plan_status = 0 where order_id  = #{id}")
    Integer setStatusLoseById(@Param("id") Integer orderId);

}
