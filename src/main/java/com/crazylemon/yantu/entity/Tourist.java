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
public class Tourist implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出游人id
     */
    @TableId(value = "tourist_id", type = IdType.AUTO)
    private Integer touristId;

    /**
     * 出游人姓名
     */
    private String touristName;

    /**
     * 出游人手机
     */
    private Long touristPhone;

    /**
     * 出游人身份信息
     */
    private String touristIdcard;

    /**
     * 出游人类型
     */
    private Integer touristType;

    /**
     * 订单id
     */
    private Integer orderId;

    private Integer touristStatus;

    private String touristXx;


}
