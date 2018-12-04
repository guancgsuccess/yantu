package com.crazylemon.yantu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Data
public class CustomizationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 私人订制主键id
     */
    @TableId(value = "customization_id", type = IdType.AUTO)
    private Integer customizationId;

    /**
     * 私人定制名
     */
    private String customizationName;

    /**
     * 出发地址
     */
    private String customizationDepart;

    /**
     * 目的地
     */
    private String customizationDestination;

    /**
     * 出发时间
     */
    private String customizationGooff;

    /**
     * 出游天数
     */
    private Integer customizationDays;

    /**
     * 出游人数
     */
    private Integer customizationNum;

    /**
     * 人均消费
     */
    private String customizationPreprice;

    /**
     * 联系人姓名
     */
    private String customizationPeopleName;

    /**
     * 联系人电话
     */
    private Long customizationPhone;

    /**
     * 联系人状态
     */
    private Integer customizationStatus;

    /**
     * 冗余字段
     */
    private String csutomizationXx;


}
