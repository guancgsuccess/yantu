package com.crazylemon.yantu.logger;



import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Controller
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.crazylemon.yantu.controller.*.*(..))")
    public void myLogger() {

    }

    @Before("myLogger()")
    public void reqMessage(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("*********BeforeBeforeBefore打印请求信息开始**********");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("*********BeforeBeforeBefore打印请求信息结束**********");

    }

    @AfterReturning(returning = "object",pointcut = "myLogger()")
    public void resMessage(Object object){
        logger.info("*********AfterReturningAfterReturningAfterReturning打印结果信息开始**********");
        logger.info("RESULT:"+ object);
        logger.info("*********AfterReturningAfterReturningAfterReturning打印结果信息结束**********");
    }

}
