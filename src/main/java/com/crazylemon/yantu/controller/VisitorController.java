package com.crazylemon.yantu.controller;


import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.service.IVisitorService;
import com.crazylemon.yantu.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/yantu/visitor")
public class VisitorController {
    private final IVisitorService iVisitorService;
    @Autowired
    public VisitorController(IVisitorService iVisitorService) {
        this.iVisitorService = iVisitorService;
    }

    /**
     * @param email
     * @return
     * 获取邮箱验证码
     */
    @PostMapping("code")
    public String getMailCode(String email){
        String mailCode = CodeUtil.generateUniqueCode();
        System.out.println(mailCode);
        MailUtil m = new MailUtil(email,mailCode);
        m.run();
        return mailCode;
    }

    /**
     * 注册
     */
    @PostMapping("register")
    public ServerResponse register(@RequestBody String jsonData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CellPhoneUtil cellPhoneUtil = mapper.readValue(jsonData,CellPhoneUtil.class);
        return iVisitorService.register(cellPhoneUtil);
    }

    @PostMapping("perfectInformation")
    public ServerResponse savePerfectInformation(@RequestBody Visitor visitor){
        System.out.println(iVisitorService.savePerfectInformation(visitor));
        return iVisitorService.savePerfectInformation(visitor);
    }

    @PostMapping("modifyPassword")
    public ServerResponse modifyPassword(@RequestBody Visitor visitor){
        return iVisitorService.modifyPassword(visitor);
    }
    @PostMapping("modifyNickName")
    public ServerResponse modifyNickName(@RequestBody Visitor visitor){
        return iVisitorService.modifyNickName(visitor);
    }
    @PostMapping("modifyName")
    public ServerResponse modifyName(@RequestBody Visitor visitor){
        return iVisitorService.modifyName(visitor);
    }
    @PostMapping("modifyPortrait")
    public ServerResponse modifyPortrait(@RequestBody Visitor visitor){
        return iVisitorService.modifyPortrait(visitor);
    }
    @PostMapping("modifyGender")
    public ServerResponse modifyGender(@RequestBody Visitor visitor){
        return iVisitorService.modifyGender(visitor);
    }
    @PostMapping("modifyIntroduction")
    public ServerResponse modifyIntroduction(@RequestBody Visitor visitor){
        return iVisitorService.modifyIntroduction(visitor);
    }
    @PostMapping("modifyTelPhone")
    public ServerResponse modifyTelPhone(@RequestBody Visitor visitor){
        return iVisitorService.modifyTelPhone(visitor);
    }
    @PostMapping("modifyEmail")
    public ServerResponse modifyEmail(@RequestBody Visitor visitor){
        return iVisitorService.modifyEmail(visitor);
    }

    @PostMapping("verificationCode")
    public Boolean validateCode(String code){
        return iVisitorService.validateCode(code);
    }

    @PostMapping("forgetPassword")
    public ServerResponse forgetPassword(LoginForm loginForm){
        Visitor visitor = iVisitorService.getByTel(loginForm.getCellphone());
        visitor.setVisitorPsw(loginForm.getPassword());
        return iVisitorService.modifyPassword(visitor);
    }
    @GetMapping("queryInformation/{visitorId}")
    public ServerResponse queryInformation(@PathVariable Integer visitorId){
        return iVisitorService.queryInformation(visitorId);
    }
}
