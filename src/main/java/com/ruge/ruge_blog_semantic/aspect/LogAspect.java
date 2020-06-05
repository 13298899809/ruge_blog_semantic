package com.ruge.ruge_blog_semantic.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName LogAspect
 * @date 2020.06.03 13:53
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.ruge.ruge_blog_semantic.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        log.info("Request : {}", requestLog);
    }

    @After("log()")
    public void doAfter() {
        log.info("--------doAfter--------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterRuturn(Object result) {
        log.info("Result : {}", result);
    }

}
