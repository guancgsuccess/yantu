package com.crazylemon.yantu.controller;


import com.crazylemon.yantu.service.ILoginService;
import com.crazylemon.yantu.utils.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 */
@CrossOrigin
@RestController
@RequestMapping("/yantu/login")
public class LoginController {
    private final ILoginService iLoginService;
    @Autowired
    public LoginController(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }
    @PostMapping("/login")
    public ServerResponse login(@RequestBody String cellPhoneUtilJson) throws IOException {
        System.out.println(cellPhoneUtilJson);
        ObjectMapper mapper = new ObjectMapper();
        CellPhoneUtil cellPhoneUtil = mapper.readValue(cellPhoneUtilJson,CellPhoneUtil.class);
        return iLoginService.login(cellPhoneUtil);

    }
    @PostMapping("code")
    public String getVerificationCode(@RequestBody String cellphone) throws IOException {
        System.out.println(cellphone);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(cellphone);
        JsonNode cell = rootNode.path("cellPhone");
        String randNum = SendTelMsgUtil.randNum;
        System.out.println("验证码是：" + randNum);
        String result = SendTelMsgUtil.sendMsgTo(cell.textValue());
        System.out.println(result);
        JsonNode resultNode = mapper.readTree(result);
        JsonNode respNode = resultNode.path("respCode");
        System.out.println(respNode.textValue());
        if(respNode.textValue().equals("00000")){
            return randNum;
        }
        return null;
//        return randNum;
    }

    @GetMapping("/logout")
    public String logout(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("loginMessage");
        return "success";
    }

}
