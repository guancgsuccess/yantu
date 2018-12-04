package com.crazylemon.yantu.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-18
 * Time: 18:43
 * Desc: 描述
 */
@Getter
public enum StatusEnums {

    SUCCESS(200, "SUCCESS"),
    ERROR(501, "ERROR"),
    NEED_LOG(100, "NEED_LOG");

    private int code;
    private String desc;

    StatusEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
