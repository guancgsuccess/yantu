package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.ScenicPhoto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface ScenicPhotoMapper extends BaseMapper<ScenicPhoto> {
    @Select("select * from scenic_photo where scenic_id = #{scenicId}")
    List<ScenicPhoto> getByScenicId(Integer scenicId);
}
