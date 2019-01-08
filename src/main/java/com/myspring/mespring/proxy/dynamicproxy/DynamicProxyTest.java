package com.myspring.mespring.proxy.dynamicproxy;

import com.myspring.mespring.proxy.staticproxy.IUser;
import com.myspring.mespring.proxy.staticproxy.UserServImpl;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        IUser iUser = (IUser) logHandler.createProxyInstance(new UserServImpl());
        iUser.findAllUser();
    }
}
