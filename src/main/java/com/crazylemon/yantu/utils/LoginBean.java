package com.crazylemon.yantu.utils;

import com.crazylemon.yantu.entity.Login;
import com.crazylemon.yantu.entity.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回的实体类
 * 用于session存储
 */
@Data
@AllArgsConstructor
public class LoginBean {
    private Login login;
    private Visitor visitor;
    private String loginMessage;
}
