package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Tourist;
import com.crazylemon.yantu.mapper.TouristMapper;
import com.crazylemon.yantu.service.ITouristService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@Service
public class TouristServiceImpl extends ServiceImpl<TouristMapper, Tourist> implements ITouristService {

    @Resource
    private TouristMapper touristMapper;
    @Override
    public Integer setTouristStatusToCancel(Integer orderId) {
        if (null!=orderId){
            return touristMapper.setTourisStatusToCancel(orderId);
        }
        return 0;
    }
}
