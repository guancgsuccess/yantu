package com.crazylemon.yantu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Planorder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方案订单详情
     */
    @TableId(value = "order_plan_id", type = IdType.AUTO)
    private Integer orderPlanId;

    /**
     * 方案id
     */
    private Integer planId;

    /**
     * 订单id
     */
    private Integer orderId;

    private Integer orderPlanStatus;

    private String orderPlanSxx;


}
