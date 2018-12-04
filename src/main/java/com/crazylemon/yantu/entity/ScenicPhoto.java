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
public class ScenicPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    @TableId(value = "photo_id", type = IdType.AUTO)
    private Integer photoId;

    /**
     * 图片名
     */
    private String photoName;

    /**
     * 图片地址
     */
    private String photoSrc;

    /**
     * 景点id
     */
    private Integer scenicId;

    private Integer photoStatus;

    private String photoXx;


}
