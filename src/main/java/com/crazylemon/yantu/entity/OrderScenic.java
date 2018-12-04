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
public class OrderScenic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单景点详情
     */
    @TableId(value = "order_scenic_id", type = IdType.AUTO)
    private Integer orderScenicId;

    /**
     * 景点id
     */
    private Integer scenicId;

    /**
     * 订单id
     */
    private Integer orderId;

    private Integer orderScenicStatus;

    /**
     * 景点票数 : 通过出游人数量自动确定
     */
    private Integer orderScenicNum;


}
