package com.crazylemon.yantu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆Id
     */
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    /**
     * 用户名
     */
    private Integer visitorId;

    /**
     * 登录方式
     */
    private String loginType;

    /**
     * 登陆IP
     */
    private String loginIp;

    /**
     * 登陆时间
     */
    private LocalDateTime loginTime;

    private Integer loginStatus;

    private String loginXx;



}
