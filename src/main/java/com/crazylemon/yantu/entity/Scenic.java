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
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Scenic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景点id
     */
    @TableId(value = "scenic_id", type = IdType.AUTO)
    private Integer scenicId;

    /**
     * 景点名称
     */
    private String scenicName;

    /**
     * 景点地址
     */
    private String scenicLocation;

    /**
     * 景点描述
     */
    private String scenicDescription;

    /**
     * 景点价格
     */
    private Double scenicPrice;

    private Integer scenicStatus;

    private String scenicXx;

    private List<Plan> planList;

    private List<ScenicPhoto> scenicPhotoList;


}
