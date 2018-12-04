package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Tourist;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface ITouristService extends IService<Tourist> {
    Integer setTouristStatusToCancel(Integer orderId);
}
