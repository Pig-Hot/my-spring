package com.myspring.mespring.springaop.springbootaop;

import org.springframework.stereotype.Component;

/**
 * Created by zhuran on 2019/1/7 0007
 */
@Component
public class TestController {
    public void testController(String name) {
        System.out.println("hello " + name);
    }
}
