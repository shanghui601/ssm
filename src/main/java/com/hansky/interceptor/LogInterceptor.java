package com.hansky.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shanghui on 2018/1/30.
 */
@Aspect
@Component
public class LogInterceptor {

    /**
     * 声明切入点
     */
    @Pointcut("@annotation(com.hansky.annotation.LogHandler)")
    public void log() {
    }

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("------before----------");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("====调用" + methodName + "方法-之前！");
    }

    @After("log()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("------after----------");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("====调用" + methodName + "方法-之后！");
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint pjoinPoint) throws Throwable {
        System.out.println("环绕通知之开始");
        Object ret = pjoinPoint.proceed();
        System.out.println("环绕通知之结束");
        return ret;
    }

    @AfterReturning(pointcut = "log()", returning = "rvt")
    public void fetchResult(JoinPoint joinPoint, Object rvt) {
        System.out.println("返回值结果");
        System.out.println(joinPoint.getArgs());
        System.out.println("切面截取:" + rvt.toString());
    }

    @AfterThrowing(pointcut = "log()", throwing = "e")
    public void afterThrowLog(JoinPoint joinPoint, Throwable e) {
        System.out.println("------@AfterThrowing----------");
        Object[] orgs = joinPoint.getArgs();
        System.out.println("------@orgs----------" + orgs);
    }

}
