package com.crazylemon.yantu.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 手机登录工具类
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CellPhoneUtil {
    private Long cellphone;
    private String password;
    private String verificationCode;

}
