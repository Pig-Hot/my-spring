package com.myspring.mespring.springaop.springbootaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zhuran on 2019/1/7 0007
 */
@Aspect
@Component
public class Aop {
    @Around("execution(* com.myspring.mespring.springaop.springbootaop.*Controller.test*(..))")
    public Object test(ProceedingJoinPoint p) throws Throwable {
        System.out.println("Hello Before");
        Object o = p.proceed(new String[]{"Tom"});
        System.out.println("Hello After");
        return o;
    }
}
