package com.letscode.log.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class VerifyRoleAspect {

    @Autowired
    private HttpServletRequest request;


    @Before("@annotation(vr)")
    public void logExecutionTime(JoinPoint joinPoint, VerifyRole vr) throws Throwable {


        String teste = request.getHeader("Authorization");
        System.out.println(teste);
        System.out.println("método executado : " + vr.role());
    }

}
