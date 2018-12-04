package com.crazylemon.yantu.controller;

import com.crazylemon.yantu.service.impl.ScenicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/yantu/searchBox")
public class SearchBoxController {

    @Autowired
    private ScenicServiceImpl scenicService;


    @GetMapping("/search")
    @ResponseBody
    public List<String> getKeyWord(String keyword){
        //获得关联数据
        List<String> listData = scenicService.selectByName(keyword);

        return listData;
    }

}
