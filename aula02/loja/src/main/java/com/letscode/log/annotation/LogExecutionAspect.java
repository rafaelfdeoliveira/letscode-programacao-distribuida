package com.letscode.log.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionAspect {

    @Before("@annotation(LogExecution)")
    public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
        System.out.println("método executado : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "@annotation(LogExecution)",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");

    }

}
