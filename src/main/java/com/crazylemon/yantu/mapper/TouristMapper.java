package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Tourist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface TouristMapper extends BaseMapper<Tourist> {


    @Update("update tourist set tourist_status = 0 where order_id = #{orderId} ")
    Integer setTourisStatusToCancel(Integer orderId);

}
