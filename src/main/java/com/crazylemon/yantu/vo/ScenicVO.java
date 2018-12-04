package com.crazylemon.yantu.vo;

import com.crazylemon.yantu.entity.ScenicPhoto;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-13
 * Time: 9:56
 * Desc: 描述
 */
@Data
public class ScenicVO {

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

    /**
     * 景点数量
     */
    private Integer scenicNum;

    private Integer scenicStatus;

    /**
     * 景点图片信息
     */
    private List<ScenicPhoto> scenicPhotoList;
}
