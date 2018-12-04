package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazylemon.yantu.utils.PageModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Repository
public interface PlanMapper extends BaseMapper<Plan> {
    /**
     * @return
     * 查看所有的方案信息
     */
    @Select("select * from plan limit #{startRecord},#{pageSize}")
    @Results({
            @Result(id = true,property = "planId",column = "plan_id"),
            @Result(property = "scenicList",column = "plan_id",
            many = @Many(select = "com.crazylemon.yantu.mapper.ScenicMapper.getByPlanId"))
    })
    List<Plan> getAll(PageModel<Plan> pageModel);

    @Select("select count(plan_id) from plan")
    Integer getCount();
    /**
     * @return
     * 查看所有的方案信息
     */
    @Select("select * from plan where plan_id = #{planId}")
    @Results({
            @Result(id = true,property = "planId",column = "plan_id"),
            @Result(property = "scenicList",column = "plan_id",
                    many = @Many(select = "com.crazylemon.yantu.mapper.ScenicMapper.getByPlanId")),
            @Result(property = "timeshaft",column = "plan_id",
                    many = @Many(select = "com.crazylemon.yantu.mapper.TimeshaftMapper.getByPlanId"))

    })
    Plan getById(Integer planId);
    @Select("select * from plan where plan_id = #{planId}")
    Plan selectById(Integer planId);
//    /**
//     * @return
//     * 增加方案信息
//     */
//    @Insert("insert into plan(plan_name,plan_description,plan_suiter,plan_season,plan_weather,plan_price,plan_discount,guider_id,plan_status) " +
//            "values(#{planName},#{planDescription},#{planSuiter},#{planSeason},#{planWeather},#{planPrice},#{planDiscount},#{guiderId},#{planStatus})")
//    Integer savePlan(Plan plan);
//
//
//    /**
//     * @param plan
//     * @return
//     * 修改方案信息
//     */
//    @Update("update scheme set plan_name = #{planDescription},plan_suiter = #{planSuiter},plan_season = #{planSeason},plan_weather = #{planWeather},plan_price = #{planPrice},plan_discount = #{planDiscount},guider_id = #{guiderId} where plan_id = #{planId}")
//    Integer modifyPlan(Plan plan);
//
//    /**
//     * @param planId
//     * @return
//     * 删除方案信息
//     */
//    @Update("update scheme set plan_status = 2 where plan_id = #{planId}")
//    Integer removePlan(Integer planId);

}
