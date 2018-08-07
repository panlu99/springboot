/**
 * FileName: WebLogAspect
 * Author: panlu02
 * Date: 2018/8/7 下午7:53
 * Description: WebLogAspect
 **/
package com.example.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(String.valueOf(WebLogAspect.class));

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.springboot.controller.*.*(..))")
    public void WebLog() {}

    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        startTime.set(System.currentTimeMillis());

        // 接收到请求，请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 请求内容
        logger.info("URL: " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD: " + request.getMethod());
        logger.info("IP: " + request.getRemoteAddr());
        logger.info("CLASS_MTHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "WebLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("Respone: " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
