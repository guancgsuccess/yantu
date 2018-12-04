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
public class Scheme implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方案景点对应关系
     */
    @TableId(value = "scheme_id", type = IdType.AUTO)
    private Integer schemeId;

    /**
     * 景点id
     */
    private Integer scenicId;

    /**
     * 方案id
     */
    private Integer planId;

    private Integer schemeStatus;

    private String schemeXx;


}
