package com.myspring.mespring.proxy.staticproxy;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        IUser iUser = new UserProxyImpl(new UserServImpl());
        iUser.findAllUser();
    }
}
