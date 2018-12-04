package com.crazylemon.yantu.utils;

public enum ResponseCode {
    ERROR(0,"ERROR"),
    SUCCESS(1,"SUCCESS"),
    DELETE_STATUS(2,"DELETE_STATUS"),
    NORMAL_STATUS(3,"NORMAL_STATUS"),
    NEED_LOG(4,"NEED_LOG");


    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
