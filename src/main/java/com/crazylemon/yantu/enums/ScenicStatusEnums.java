package com.crazylemon.yantu.enums;


import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-18
 * Time: 21:43
 * Desc: 描述
 */
@Getter
public enum  ScenicStatusEnums implements CodeEnums<Integer> {

    CLOSE(0 , "景点失效"),
    CREATE(1 , "景点有效"),
    ;
    private Integer code;

    private String msg;

    ScenicStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
