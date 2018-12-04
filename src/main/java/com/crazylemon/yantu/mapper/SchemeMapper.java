package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Scheme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface SchemeMapper extends BaseMapper<Scheme> {
    /**
     * @return
     * 根据scenic和plan的id查询(添加plan信息)
     */
    @Select("select * from scheme where scenic_id = #{scenicId} and plan_id = #{planId}")
    List<Scheme> getByScenicAndPlanId(Integer scenicId,Integer planId);

    /**
     * @return
     * 如果没有查询到信息,则添加数据
     */
    @Insert("insert into scheme(scenic_id,plan_id,scheme_status) values(scenicId,plan_id,schemeStatus)")
    Integer saveScheme(Scheme scheme);

    /**
     * @return
     * 如果查询到信息了,则修改原信息
     */
    @Update("update scheme set scenic_id = #{scenicId},plan_id = #{planId},scheme_status = #{schemeStatus} where scheme_id = #{schemeId}")
    Integer modifyScheme(Scheme scheme);

    /**
     * @return
     * 删除scheme信息
     */
    @Update("update scheme set scheme_status = 2 where scheme_id = schemeId")
    Integer removeScheme(Integer schemeId);


    /**
     * @param planId
     * @return
     * 根据方案id查询scheme
     */
    @Select("select * from scheme where plan_id = #{planId}")
    List<Scheme> getSchemeList(Integer planId);
}
