package com.crazylemon.yantu.controller;


import com.crazylemon.yantu.entity.Tourist;
import com.crazylemon.yantu.service.ITouristService;
import com.crazylemon.yantu.service.impl.TouristServiceImpl;
import com.crazylemon.yantu.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private ITouristService touristService;

    @PostMapping("/save")
    public ServiceResult<Boolean> saveTourist(Tourist tourist){
        if (tourist == null){
            return ServiceResult.createByError("保存失败");
        }

        Boolean flag = touristService.save(tourist);

        return ServiceResult.createByCheckSuccess("保存成功",flag);

    }


}
