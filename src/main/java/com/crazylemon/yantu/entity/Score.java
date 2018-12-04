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
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评分评价id
     */
    @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 评分
     */
    private Integer scoreGrade;

    private Integer scoreStatus;

    private String scoreXx;


}
