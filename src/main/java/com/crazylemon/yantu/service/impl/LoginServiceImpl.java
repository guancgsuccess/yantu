package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.controller.LoginController;
import com.crazylemon.yantu.entity.Login;
import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.mapper.LoginMapper;
import com.crazylemon.yantu.mapper.VisitorMapper;
import com.crazylemon.yantu.service.ILoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {
    private final LoginMapper loginMapper;
    private final VisitorMapper visitorMapper;
    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper, VisitorMapper visitorMapper) {
        this.loginMapper = loginMapper;
        this.visitorMapper = visitorMapper;
    }
    @Override
    public ServerResponse<Visitor> login(CellPhoneUtil cellPhoneUtil) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        ServerResponse serverResponse = (ServerResponse)session.getAttribute("loginMessage");
        Visitor visitor;
        if(serverResponse == null){
            if(cellPhoneUtil.getPassword() != null && cellPhoneUtil.getCellphone() != null){
               visitor = visitorMapper.getByTel(cellPhoneUtil.getCellphone());
               if(visitor!=null){
                   if(cellPhoneUtil.getPassword().equals(visitor.getVisitorPsw())){
                       if(visitor.getLogin() == null){
                           Login login = new Login();
                           login.setVisitorId(visitor.getVisitorId());
                           login.setLoginType("手机密码登录");
                           login.setLoginIp(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getLocalAddr());
                           login.setLoginTime(LocalDateTime.now());
                           login.setLoginStatus(ResponseCode.SUCCESS.getCode());
                           loginMapper.save(login);
                       }else {
                           //login == null save login
                           Login login = loginMapper.getByVisitorId(visitor.getVisitorId());
                           login.setLoginType("手机密码登录");
                           login.setLoginIp(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getLocalAddr());
                           login.setLoginTime(LocalDateTime.now());
                           login.setLoginStatus(ResponseCode.SUCCESS.getCode());
                           loginMapper.modify(login);
                       }
                       System.out.println(visitor);
                       session.setAttribute("loginMessage",new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitor,"登录成功!"));
                       return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitor,"登录成功!");
                   }else {
                       return new ServerResponse<>(ResponseCode.ERROR.getCode(),"密码输入错误");
                   }
               }else {
                   //visitor == null 用户不存在.
                   return new ServerResponse<>(ResponseCode.ERROR.getCode(),"用户不存在");
               }
            }else if(cellPhoneUtil.getVerificationCode() != null && cellPhoneUtil.getCellphone() != null ){
                visitor = visitorMapper.getByTel(cellPhoneUtil.getCellphone());
                System.out.println(cellPhoneUtil.getVerificationCode());
                System.out.println(SendTelMsgUtil.createRandNum());
                    if(visitor != null){
                        if(visitor.getLogin() == null){
                            Login login = new Login();
                            login.setVisitorId(visitor.getVisitorId());
                            login.setLoginType("手机验证码登录");
                            login.setLoginIp(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getLocalAddr());
                            login.setLoginTime(LocalDateTime.now());
                            login.setLoginStatus(ResponseCode.SUCCESS.getCode());
                            loginMapper.save(login);
                        }else {
                            //login == null save login
                            Login login = loginMapper.getByVisitorId(visitor.getVisitorId());
                            login.setLoginType("手机验证码登录");
                            login.setLoginIp(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getLocalAddr());
                            login.setLoginTime(LocalDateTime.now());
                            login.setLoginStatus(ResponseCode.SUCCESS.getCode());
                            loginMapper.modify(login);
                        }
                        System.out.println(visitor);
                        session.setAttribute("loginMessage",new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitor,"登录成功!"));
                        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitor,"登录成功!");
                    }else {
                        //visitor == null 注册并登录
                        Visitor visitor1 = new Visitor();
                        visitor1.setVisitorTel(cellPhoneUtil.getCellphone());
                        Integer result = visitorMapper.save(visitor1);
                        if(result > 0){
                            Login login = new Login();
                            login.setVisitorId(visitorMapper.getByTel(cellPhoneUtil.getCellphone()).getVisitorId());
                            login.setLoginType("手机验证码登录");
                            login.setLoginIp(request.getLocalAddr());
                            login.setLoginTime(LocalDateTime.now());
                            login.setLoginStatus(ResponseCode.SUCCESS.getCode());
                            System.out.println(login);
                            loginMapper.save(login);
                            Visitor visitorSuccess = visitorMapper.getByTel(visitor1.getVisitorTel());
                            session.setAttribute("loginMessage",new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitorSuccess,"登录成功!"));
                            return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),visitorSuccess,"登录成功!");
                        }else {
                            System.out.println("注册失败");
                            return new ServerResponse<>(ResponseCode.ERROR.getCode(),"注册失败");
                        }
                    }

            }else {
                return new ServerResponse<>(ResponseCode.ERROR.getCode(),"输入不正确");
            }
        }else {
            if(serverResponse.getStatus()==ResponseCode.SUCCESS.getCode()){
                return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),(Visitor) serverResponse.getData(),"session登录成功!");
            }else {
                return new ServerResponse<>(ResponseCode.ERROR.getCode(),"输入不正确");
            }
        }

    }
}
