package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Scenic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScenicVO;
import com.crazylemon.yantu.vo.ServiceResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>

 */
public interface IScenicService extends IService<Scenic> {
    ServerResponse getById(Integer scenicId);
    ServerResponse getAll(Integer pageCode);
    List<String> selectByName (String name);
    ServiceResult<ScenicVO> getScenicById(Integer scenicId);
    ServerResponse getByName(String name);

}
