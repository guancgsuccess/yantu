package com.crazylemon.yantu.vo;

import com.crazylemon.yantu.entity.Tourist;
import com.crazylemon.yantu.entity.Visitor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * User: Wangzh
 * Date: 2018-11-07
 * Time: 9:15
 * Desc: 描述
 */
@Data
public class ScoreVO {
    private Integer scoreId;
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 评分
     */
    private Integer scoreGrade;

    /**
     * 评分状态
     */
    private Integer scoreStatus;

    /**
     * 评分信息
     */
    private String scoreXx;

    /**
     * visitor_nickname
     */
    private String visitorNickname;

    /**
     * visitor_portrait
     */
    private String visitorPortrait;

    private LocalDateTime orderCreatetime;
}
