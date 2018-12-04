package com.crazylemon.yantu.vo;

import com.crazylemon.yantu.enums.StatusEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-13
 * Time: 14:16
 * Desc: 描述
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ServiceResult<T> {
    //状态码
    private int status;
    //描述信息
    private String msg;
    //实际数据
    private T data;

    public ServiceResult(int status) {
        this.status = status;
    }

    /**
     * 操作成功返回数据
     * @param status
     * @param msg
     * @param data
     */
    public ServiceResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作失败时返回数据
     * @param status
     * @param msg
     */
    public ServiceResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //使之不在序列化结果中
    @JsonIgnore
    public boolean checkIsSuccess(){
        return this.status == StatusEnums.SUCCESS.getCode();
    }

    /**
     * 返回成功后创建的对象
     * @param <T>
     * @return
     */
    public static <T> ServiceResult<T> createByCheckSuccess(String msg,T data){
        return new ServiceResult<T>(StatusEnums.SUCCESS.getCode(),msg,data);
    }

    /**
     * 返回失败后创建的对象
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServiceResult<T> createByError(String msg){
        return new ServiceResult<T>(StatusEnums.ERROR.getCode(),msg);
    }


    /**
     * 返回未登录时创建的对象
     * @param <T>
     * @return
     */
    public static <T> ServiceResult<T> createByNeedLogin(){
        return new ServiceResult<T>(StatusEnums.NEED_LOG.getCode(),"您还未登录,请先登录再进行操作！");
    }


}
