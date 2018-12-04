package com.crazylemon.yantu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方案id
     */
    @TableId(value = "plan_id", type = IdType.AUTO)
    private Integer planId;

    /**
     * 方案名称
     */
    private String planName;

    /**
     * 方案描述
     */
    private String planDescription;

    /**
     * 方案适宜人数
     */
    private Integer planSuiter;

    /**
     * 方案适宜季节
     */
    private String planSeason;

    /**
     * 方案适宜天气
     */
    private String planWeather;

    /**
     * 方案价格
     */
    private Double planPrice;

    /**
     * 方案折扣价格
     */
    private Double planDiscount;

    /**
     * 导游工号
     */
    private Integer guiderId;

    private Integer planStatus;

    private String planXx;

    private List<Scenic> scenicList;

    private List<Timeshaft> timeshaft;

}
