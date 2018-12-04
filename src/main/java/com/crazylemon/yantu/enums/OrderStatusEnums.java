package com.crazylemon.yantu.enums;


import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-16
 * Time: 18:59
 * Desc: 描述
 */
@Getter
public enum OrderStatusEnums implements CodeEnums<Integer> {

    NEW(0 , "新订单"),
    FINISH(1 , "完成订单"),
    CANCEL(2 , "失效取消订单")
    ;
    private Integer code;

    private String msg;

    OrderStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
