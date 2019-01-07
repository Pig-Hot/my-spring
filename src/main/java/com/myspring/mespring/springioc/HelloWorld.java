package com.myspring.mespring.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

/**
 * Created by fuchaochao on 16/8/5.
 */
public class HelloWorld implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean,ApplicationContextAware {
    private String message;

    public HelloWorld(){
        System.out.println("3.HelloWorld struct.......");
    }

    private static ApplicationContext applicationContext;

    /**
     * 服务器启动，Spring容器初始化时，当加载了当前类为bean组件后，
     * 将会调用下面方法注入ApplicationContext实例
     */
    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        System.out.println("8.加载本类为Bean组件,注入ApplicationContext实例");
        HelloWorld.applicationContext = arg0;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 外部调用这个getBean方法就可以手动获取到bean
     * 用bean组件的name来获取bean
     *
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void xml_init(){
        //xml开头的表示配置文件配置,这里是bean配置中init-method配置调用
        System.out.println("12.HelloWorld 初始化(init-method)");
    }
    public void xml_destroy(){
        //destroy-method 配置调用
        System.out.println("17.HelloWorld 销毁(destroy-method)");
    }

    public void setBeanName(String s) {
        //属性注入后调用
        System.out.println("6.setBeanName(BeanNameAware) 属性注入后调用, 此时s = " + s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //setBeanName 后调用
        System.out.println("7.setBeanFactory(BeanFactory) setBeanName后调用");
    }

    public void afterPropertiesSet() throws Exception {
        //processBeforeInitialization(BeanPostProcessor)后调用
        System.out.println("11.afterPropertiesSet(InitializingBean) processBeforeInitialization之后,配置的xml_init之前调用");
    }

    public void destroy() throws Exception {
        System.out.println("16.destroy(DisposableBean) 在processAfterInitialization之后,配置的xml_destroy之前调用");
    }
}