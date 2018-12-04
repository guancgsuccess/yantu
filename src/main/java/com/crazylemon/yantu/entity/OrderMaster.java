package com.crazylemon.yantu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 出游天数
     */
    private Integer orderDays;

    /**
     * 订单创建时间
     */
    private LocalDateTime orderCreatetime;

    /**
     * 订单保险信息
     */
    private String orderInsurance;

    /**
     * 出游人数
     */
    private Integer orderNum;

    /**
     * 订单总价
     */
    private Double orderPrice;

    /**
     * 客户用户名
     */
    private Integer visitorId;

    private Integer orderStatus;

    private String orderXx;


}
