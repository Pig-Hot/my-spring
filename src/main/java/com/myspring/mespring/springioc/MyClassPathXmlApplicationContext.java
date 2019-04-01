package com.myspring.mespring.springioc;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhuran on 2019/3/29 0029
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
//        beanFactory = null;

        System.out.println("------" + beanFactory + "------");
    }
    public MyClassPathXmlApplicationContext(String configLocatio){
        super(configLocatio);
    }
}
