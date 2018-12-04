package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Planorder;

import com.baomidou.mybatisplus.extension.service.IService;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**

 - <p>
 - 服务类
 - </p>
 *
 - @author wangzh
 - @since 2018-10-09
 */
public interface IPlanorderService extends IService<Planorder> {
    List<Integer> getPlanIdList(Integer orderId);
    Integer setStatusLoseById(Integer orderId);
}
