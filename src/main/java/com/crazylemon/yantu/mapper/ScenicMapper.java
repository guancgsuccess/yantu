package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.entity.Scenic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazylemon.yantu.utils.PageModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Repository
public interface ScenicMapper extends BaseMapper<Scenic> {


    @Select("select * from scenic where scenic_id in(select scenic_id from scheme where plan_id = #{planId})")
    @Results({
            @Result(id = true,property = "scenicId",column = "scenic_id"),
            @Result(property = "scenicPhotoList",column = "scenic_id",
            many = @Many(select = "com.crazylemon.yantu.mapper.ScenicPhotoMapper.getByScenicId"))
    })
    List<Scenic> getByPlanId(Integer planId);

    @Select("select * from scenic where scenic_id = #{scenicId}")
    @Results({
            @Result(id = true,property = "scenicId",column = "scenic_id"),
            @Result(property = "scenicPhotoList",column = "scenic_id",
                    many = @Many(select = "com.crazylemon.yantu.mapper.ScenicPhotoMapper.getByScenicId"))
    })
    Scenic getById(Integer scenicId);

    @Select("select * from scenic limit #{startRecord},#{pageSize}")
    @Results({
            @Result(id = true,property = "scenicId",column = "scenic_id"),
            @Result(property = "scenicPhotoList",column = "scenic_id",
                    many = @Many(select = "com.crazylemon.yantu.mapper.ScenicPhotoMapper.getByScenicId"))
    })
    List<Scenic> getAll(PageModel<Scenic> pageModel);

    @Select("select count(scenic_id) from scenic")
    Integer getCount();

    @Select("select scenic_name,scenic_location from scenic where scenic_name like concat('%',#{name},'%') or scenic_location like concat('%',#{name},'%')" )
    List<String> selectByName(@Param("name") String name);

    @Select("select * from scenic where scenic_id = #{scenicId}")
    Scenic selectById(Integer scenicId);

    @Select("select * from scenic where scenic_name = #{name}")
    Scenic getByName(String name);

}
