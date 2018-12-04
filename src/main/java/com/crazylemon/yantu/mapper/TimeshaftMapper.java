package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Timeshaft;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface TimeshaftMapper extends BaseMapper<Timeshaft> {

    @Select("select * from timeshaft where plan_id = #{planId}")
    List<Timeshaft> getByPlanId(Integer planId);
}
