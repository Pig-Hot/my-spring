package com.myspring.mespring.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;
    public Object getInstance(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(object.getClass());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：调对于代理类上所有方法的用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        beforeLog();
        //有两种使用方法:1.invoke需要调用的对象是目标对象,2.invokeSuper需要调用对象是代理对象
//        Object object = methodProxy.invokeSuper(o,objects);//调用父类中的方法
        Object object = methodProxy.invoke(this.object,objects);//调用父类中的方法
        afterLog();
        return object;
    }

    private void beforeLog(){
        System.out.println("开始执行");
    }

    private void afterLog(){
        System.out.println("执行完毕");
    }
}
