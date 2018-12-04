package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Guider;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.utils.ServerResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
public interface IGuiderService extends IService<Guider> {
    /**
     * 分页查询 导游信息
     * @param currentPageCode
     * @return
     */
    ServerResponse getGuiderBypage(Integer currentPageCode);
}
