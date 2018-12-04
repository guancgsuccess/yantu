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
public class Pair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配对
     */
    @TableId(value = "pair_id", type = IdType.AUTO)
    private Integer pairId;

    /**
     * 配对名
     */
    private String pairName;

    /**
     * 配对人数
     */
    private Integer pairNumber;

    /**
     * 配对时间
     */
    private LocalDateTime pairTime;

    /**
     * 配对要求
     */
    private String pairWant;

    /**
     * 景点id
     */
    private Integer scenicId;

    private Integer pairStatus;

    private String pairXx;


}
