package com.crazylemon.yantu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "visitor_id", type = IdType.AUTO)
    private Integer visitorId;

    /**
     * 用户电话
     */
    private Long visitorTel;

    /**
     * 用户密码
     */
    private String visitorPsw;

    /**
     * 用户姓名
     */
    private String visitorName;

    /**
     * 用户邮箱
     */
    private String visitorEmail;

    /**
     * 用户昵称
     */
    private String visitorNickname;

    /**
     * 用户头像
     */
    private String visitorPortrait;

    /**
     * 用户性别
     */
    private Integer visitorGender;

    /**
     * 用户状态
     */
    private Integer visitorStatus;

    /**
     * 用户介绍
     */
    private String visitorIntroduction;

    private String visitorXx;

    private Login login;

}
