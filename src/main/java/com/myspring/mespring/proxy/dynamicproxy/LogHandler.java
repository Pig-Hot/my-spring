package com.myspring.mespring.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class LogHandler implements InvocationHandler {
    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        beforeLog();
        obj = method.invoke(targetObject,args);
        afterLog();
        return obj;
    }

    private void beforeLog(){
        System.out.println("开始执行");
    }

    private void afterLog(){
        System.out.println("执行完毕");
    }
}
