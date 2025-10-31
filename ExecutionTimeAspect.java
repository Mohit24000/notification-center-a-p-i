package com.learnSpringBoot.notificationcenter.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Around("@annotation(com.learnSpringBoot.notificationcenter.aop.LogExecutionTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        System.out.println("TIME " + joinPoint.getSignature() + " executed in " + time + "ms");
        return result;
    }
}
