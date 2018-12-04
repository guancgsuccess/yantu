package com.crazylemon.yantu.mapper;
import com.crazylemon.yantu.entity.Score;
import com.crazylemon.yantu.entity.Visitor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazylemon.yantu.vo.ScoreVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Mapper
@Repository
public interface VisitorMapper extends BaseMapper<Visitor> {
    /**
     * @return 游客集合
     * 查询全部游客(非分页)
     */
    @Select("select * from visitor")
    @Results({
            @Result(id = true,property = "visitorId",column = "visitor_id"),
            @Result(property = "login",column = "visitor_id",
                    one = @One(select = "com.crazylemon.yantu.mapper.LoginMapper.getByVisitorId")
            )
    })
    List<Visitor> getAll();
    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 注册一名游客
     */
    @Insert("insert into visitor(visitor_tel,visitor_psw) values(#{visitorTel},#{visitorPsw})")
    Integer register(Visitor visitor);
    @Insert("insert into visitor(visitor_tel) values(#{visitorTel})")
    Integer save(Visitor visitor);
    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 完善注册的游客信息
     */
    @Update("update visitor set visitor_name=#{visitorName},visitor_email=#{visitorEmail},visitor_nickname=#{visitorNickname}," +
            "visitor_portrait=#{visitorPortrait},visitor_gender=#{visitorGender}," +
            "visitor_introduction=#{visitorIntroduction} where visitor_id=#{visitorId}")
    Integer savePerfectInformation(Visitor visitor);
    /**
     * @param visitorId
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 删除游客信息(根据游客ID进行伪删除)
     */
    @Update("update visitor set visitor_status = 0 where visitor_id = #{visitorId}")
    Integer remove(Integer visitorId);
    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 修改顾客信息
     */
    @Update("update visitor set visitor_tel = #{visitorTel},visitor_psw = #{visitorPsw},visitor_name = #{visitorName},visitor_email = #{visitorEmail},visitor_nickname=#{visitorNickname},visitor_portrait=#{visitorPortrait},visitor_gender=#{visitorGender}," +
            "visitor_introduction=#{visitorIntroduction},visitor_xx=#{visitorXx} where visitor_id=#{visitorId}")
    Integer modifyVisitorInformation(Visitor visitor);
    @Update("update visitor set visitor_nickname=#{visitorNickname} where visitor_id = #{visitorId}")
    Integer modifyNickName(Visitor visitor);
    @Update("update visitor set visitor_name=#{visitorName} where visitor_id = #{visitorId}")
    Integer modifyName(Visitor visitor);
    @Update("update visitor set visitor_portrait=#{visitorPortrait} where visitor_id = #{visitorId}")
    Integer modifyPortrait(Visitor visitor);
    @Update("update visitor set visitor_gender=#{visitorGender} where visitor_id = #{visitorId}")
    Integer modifyGender(Visitor visitor);
    @Update("update visitor set visitor_introduction=#{visitorIntroduction} where visitor_id = #{visitorId}")
    Integer modifyIntroduction(Visitor visitor);

    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 修改绑定手机号
     */
    @Update("update visitor set visitor_tel = #{visitorTel} where visitor_id = #{visitorId}")
    Integer modifyTelPhone(Visitor visitor);
    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 修改密码
     */
    @Update("update visitor set visitor_psw = #{visitorPsw} where visitor_id = #{visitorId}")
    Integer modifyPassword(Visitor visitor);
    /**
     * @param visitor
     * @return 受影响的行数(0为添加失败,1为添加成功)
     * 修改绑定邮箱
     */
    @Update("update visitor set visitor_email = #{visitorEmail} where visitor_id = #{visitorId}")
    Integer modifyEmail(Visitor visitor);
   /**
     * @return 查询出来的Visitor数据
     * 根据手机号查询
     */
    @Select("select * from visitor where visitor_tel = #{visitorTel}")
    @Results({
            @Result(id = true,property = "visitorId",column = "visitor_id"),
            @Result(property = "login",column = "visitor_id",
                    one = @One(select = "com.crazylemon.yantu.mapper.LoginMapper.getByVisitorId")
            )
    })
    Visitor getByTel(Long visitorTel);

    /**
     * @param visitor_email
     * @return
     * 根据邮箱查询游客
     */
    @Select("select * from visitor where visitor_email = #{visitorEmail}")
    @Results({
            @Result(id = true,property = "visitorId",column = "visitor_id"),
            @Result(property = "login",column = "visitor_id",
                    one = @One(select = "com.crazylemon.yantu.mapper.LoginMapper.getByVisitorId")
            )
    })
    Visitor getByEmail(String visitor_email);
    /**
     * @param visitorId
     * @return
     * 根据id查询游客
     */
    @Select("select * from visitor where visitor_id = #{visitorId}")
    @Results({
            @Result(id = true,property = "visitorId",column = "visitor_id"),
            @Result(property = "login",column = "visitor_id",
                    one = @One(select = "com.crazylemon.yantu.mapper.LoginMapper.getByVisitorId")
            )
    })
    Visitor getById(Integer visitorId);

    @Select("select visitor_nickname,visitor_portrait from visitor where visitor_id = #{visitorId}")
    ScoreVO getScoreVOByVisitorID(Integer visitorId);
}
