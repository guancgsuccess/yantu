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
public class Guider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 导游工号
     */
    @TableId(value = "guider_id", type = IdType.AUTO)
    private Integer guiderId;

    /**
     * 导游姓名
     */
    private String guiderName;

    /**
     * 导游证件照
     */
    private String guiderIdphoto;

    /**
     * 导游资历
     */
    private Integer guiderQualification;

    /**
     * 导游等级
     */
    private Integer guiderGrade;

    /**
     * 导游介绍
     */
    private String guiderIntroduction;

    private Integer guiderStatus;

    private String guiderXx;


}
