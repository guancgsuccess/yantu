package com.crazylemon.yantu.controller;



import com.crazylemon.yantu.entity.Customization;
import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.service.impl.CustomizationServiceImpl;
import com.crazylemon.yantu.service.impl.VisitorServiceImpl;
import com.crazylemon.yantu.vo.CustomizationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/yantu/customization")
public class CustomizationController {

    @Autowired
    private CustomizationServiceImpl service;

    @Autowired
    private VisitorServiceImpl visitorService;

    @PostMapping("/save")
    public Integer saveCustomization(CustomizationVO customizationvo){
        System.out.println(customizationvo);
        if(null == customizationvo){
            return 0;
        }
        Customization customization = new Customization();

        BeanUtils.copyProperties(customizationvo,customization);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(customizationvo.getCustomizationGooff(),dateTimeFormatter);
        String price = customizationvo.getCustomizationPreprice().split("-")[1];
        String titleTime = localDateTime.format(dateTimeFormatter);
        customization.setCustomizationName(titleTime+"-"+customizationvo.getCustomizationPeopleName()+"的旅游定制");
        customization.setCustomizationGooff(localDateTime);
        customization.setCustomizationPreprice(Double.parseDouble(price));
        boolean result = service.save(customization);
        return 0;
    }
}
