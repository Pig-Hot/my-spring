package com.myspring.mespring;

import com.myspring.mespring.springaop.springbootaop.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class MeSpringApplication {


    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(MeSpringApplication.class, args);
        TestController controller = (TestController) app.getBean("testController");
        controller.testController("");
    }

}

