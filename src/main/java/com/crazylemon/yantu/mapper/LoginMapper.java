package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Login;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Repository
public interface LoginMapper extends BaseMapper<Login> {
    /**
     * @param visitorId
     * @return
     * 根据游客id查询登录信息,如果为null则添加一条数据
     * 如果存在,则修改登录信息
     */
    @Select("select * from login where visitor_id = #{visitorId}")
    Login getByVisitorId(Integer visitorId);
    /**
     * @param login
     * @return
     * 添加登录信息
     */
    @Insert("insert into login(visitor_id,login_type,login_ip,login_time,login_status,login_xx) " +
            "values(#{visitorId},#{loginType},#{loginIp},#{loginTime},#{loginStatus},#{loginXx})")
    Integer save(Login login);

    /**
     * @param login
     * @return
     * 修改登录信息
     */
    @Update("update login set login_type = #{loginType},login_ip = #{loginIp},login_time =#{loginTime},login_status = #{loginStatus},login_xx = #{loginXx} where visitor_id = #{visitorId}")
    Integer modify(Login login);


}
