package com.crazylemon.yantu.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 生成邮箱验证码
 */
public class CodeUtil {
    //生成唯一的激活码
//    public static String generateUniqueCode(){
//        return UUID.randomUUID().toString().replaceAll("-", "");
//    }

    public static String generateUniqueCode() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <= 5; i++) {
            String s = random.nextInt(10) + "";
            sb.append(s);
        }
        return sb.toString();
    }

}
