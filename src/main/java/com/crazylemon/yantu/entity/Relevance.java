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
public class Relevance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方案类型关联id
     */
    @TableId(value = "relevance_id", type = IdType.AUTO)
    private Integer relevanceId;

    /**
     * 方案id
     */
    private Integer planId;

    /**
     * 方案类型id
     */
    private Integer categoryId;

    private Integer relevanceStatus;

    private String relrvanceXx;


}
