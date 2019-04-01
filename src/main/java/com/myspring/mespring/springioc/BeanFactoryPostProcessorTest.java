package com.myspring.mespring.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by fuchaochao on 16/8/12.
 */
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    static ConfigurableListableBeanFactory instance;
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        instance = configurableListableBeanFactory;
        int hash = configurableListableBeanFactory.hashCode();
        configurableListableBeanFactory=null;
    }
    public static  ConfigurableListableBeanFactory getFactory(){
        return instance;
    }

}