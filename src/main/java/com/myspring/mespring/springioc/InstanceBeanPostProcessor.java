package com.myspring.mespring.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * Created by fuchaochao on 16/8/12.
 */
public class InstanceBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        System.out.println("2.实例化bean之前调用,即调用bean类构造函数之前调用 " + aClass.getName());
        /*try {
            return Class.forName(""+aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return null;//其实我不是很明白这里返回值得作用,之后可能会去深入理解
    }

    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        System.out.println("4.返回boolean,bean实例化后调用,并且返回false则不会注入属性");
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("5.postProcessPropertyValues,在属性注入之前调用...... beanName = " + s + " 属性名集合 : " + Arrays.toString(propertyValues.getPropertyValues()));
        //System.out.println("message = " + ((HelloWorld)o).getMessage()); 这里可以看到message还是null
        return propertyValues;//这里要返回propertyValues,否则属性无法注入
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("10.postProcessBeforeInitialization(InstantiationAwareBeanPostProcessor) ");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("14.postProcessAfterInitialization(InstantiationAwareBeanPostProcessor) ");
        return o;
    }
}
