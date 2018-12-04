package com.crazylemon.yantu.utils;

import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.entity.Scenic;
import com.crazylemon.yantu.entity.Tourist;
import com.crazylemon.yantu.vo.ScenicVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 手机登录工具类
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfoUtil {

    /**
     * 订单保险信息
     */
    private String orderInsurance = "沿途赠送个人意外险";

    /**
     * 出游人数
     */
    private Integer orderNum;

    /**
     * 客户用户名
     */
    private Integer visitorId;

    /**
     * 出游人集合
     */
    List<Tourist> touristList;

    /**
     * 景点ID
     */
    Integer scenicId;

    /**
     * 方案ID
     */
    Integer planId;
}
