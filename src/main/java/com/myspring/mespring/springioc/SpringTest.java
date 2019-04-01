package com.myspring.mespring.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fuchaochao on 16/8/12.
 */
public class SpringTest {
    public static void main(String[] args){
        ApplicationContext context = new MyClassPathXmlApplicationContext("appcontext-*.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.equals(helloWorld2));
//        HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
//        System.out.println("15.Bean working, message = " + obj.getMessage());
        //((ClassPathXmlApplicationContext)context).refresh();
        ((ClassPathXmlApplicationContext)context).close();
    }
}