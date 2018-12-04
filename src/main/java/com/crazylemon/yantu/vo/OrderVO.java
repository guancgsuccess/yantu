package com.crazylemon.yantu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.entity.Scenic;
import com.crazylemon.yantu.entity.Tourist;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-10-17
 * Time: 18:46
 * Desc: 描述订单的视图对象
 */
@Data
public class OrderVO implements Serializable{
    /**
     * 总订单id
     */
    private Integer orderId;

    /**
     * 出游天数
     */
    private Integer orderDays;

    /**
     * 订单创建时间
     */
    private LocalDateTime orderCreatetime;

    /**
     * 订单保险信息
     */
    private String orderInsurance;

    /**
     * 出游人数
     */
    private Integer orderNum;

    /**
     * 订单总价
     */
    private Double orderPrice;

    /**
     * 客户用户名
     */
    private Integer visitorId;

    /**
     * 订单状态:默认为:0-未支付
     */
    private Integer orderStatus;

    /**
     * 出游人集合
     */
    List<Tourist> touristList;

    /**
     * 景点集合
     */
    List<ScenicVO> scenicList;

    /**
     * 方案集合
     */
    List<Plan> planList;

}
