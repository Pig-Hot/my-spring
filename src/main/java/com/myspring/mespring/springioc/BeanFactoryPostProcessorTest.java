package com.myspring.mespring.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by fuchaochao on 16/8/12.
 */
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.getBeanDefinition("appcontext-service.xml");
        System.out.println("1.postProcessBeanFactory(BeanFactoryPostProcessor) 工厂后处理器, ApplicationContext容器初始化中refresh()中调用");
    }
}