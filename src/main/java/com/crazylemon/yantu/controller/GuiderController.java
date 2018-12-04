package com.crazylemon.yantu.controller;


import com.crazylemon.yantu.service.impl.GuiderServiceImpl;
import com.crazylemon.yantu.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/yantu/guider")
public class GuiderController {
    private final GuiderServiceImpl guiderService;

    @Autowired
    public GuiderController(GuiderServiceImpl guiderService) {
        this.guiderService = guiderService;
    }

    /**
     * 2 分页查询所有导游
     *
     * @return
     */
    @GetMapping("page/{pagecode}")
    public ServerResponse getAllGuider(@PathVariable("pagecode") Integer pagecode) {
        ServerResponse serverResponse = null;
        System.out.println("进入/page/{pagecode} controller");
        serverResponse = guiderService.getGuiderBypage(pagecode);
        System.out.println("controller :"+serverResponse);
        return serverResponse;
    }
}
