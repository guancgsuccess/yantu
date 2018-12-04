package com.crazylemon.yantu.utils;

import lombok.Data;

/**
 * 登录参数封装
 */
@Data
public class LoginForm {
    private Long cellphone;
    private String password;
    private String email;
    private String verificationCode;
}
