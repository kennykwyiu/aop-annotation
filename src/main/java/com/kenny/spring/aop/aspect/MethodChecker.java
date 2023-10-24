package com.kenny.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class MethodChecker {
    ////ProceedingJoinPoint is an upgraded version of JoinPoint,
    // in addition to the original function, you can also control whether the target method is executed.
    @Around("execution(* com.kenny..*Service.*(..))")
//    @Before()
//    @After()
//    @AfterReturning
//    @AfterThrowing
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            long startTime = new Date().getTime();
            Object retuning = proceedingJoinPoint.proceed();
            long endTime = new Date().getTime();
            long duration = endTime - startTime;
            if (duration >= 1000) {
                String className = proceedingJoinPoint.getTarget().getClass().getName();
                String methodName = proceedingJoinPoint.getSignature().getName();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String now = simpleDateFormat.format(new Date());
                System.out.println("======" + now + ":" + className + "." + methodName + "(" + duration + "ms)======");
            }
            return retuning;
        } catch (Throwable throwable) {
            System.out.println("Exception message: " + throwable.getMessage());
            throw throwable;
        }
    }
}
