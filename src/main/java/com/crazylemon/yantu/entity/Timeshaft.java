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
public class Timeshaft implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间轴id
     */
    @TableId(value = "timeshaft_id", type = IdType.AUTO)
    private Integer timeshaftId;

    /**
     * 时间轴时间点
     */
    private String timeshaftTime;

    /**
     * 时间点描述
     */
    private String timeshaftDescription;

    /**
     * 景点id
     */
    private Integer scenicId;

    /**
     * 方案id
     */
    private Integer planId;

    private Integer timeshaftStatus;

    private String timeshaftXx;


}
