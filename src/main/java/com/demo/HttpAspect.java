package com.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by duhaiyang on 2018/2/4.
 */

@Component
@Aspect
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Before("log()")
    public void beforelog(JoinPoint joinpoint){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        logger.info("url = {}",request.getRequestURL());
        logger.info("method = {}",request.getMethod());
        logger.info("ip = {}",request.getRemoteAddr());
        logger.info("class_method = {}",joinpoint.getSignature().getDeclaringTypeName()+ joinpoint.getSignature().getName());
        logger.info("args = {}",joinpoint.getArgs());
    }

    @After("log()")
    public void afterlog(){
        logger.info("bbbbbb");
    }


    @Pointcut("execution(public * com.demo.HellowController.*(..))")
    public void log(){

    }
}
