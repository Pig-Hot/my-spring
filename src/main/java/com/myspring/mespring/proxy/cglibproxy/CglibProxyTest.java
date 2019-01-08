package com.myspring.mespring.proxy.cglibproxy;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        UserServImpl userServ = new UserServImpl();
        CglibProxy cglibProxy = new CglibProxy();
        UserServImpl userServ1 = (UserServImpl) cglibProxy.getInstance(userServ);
        userServ1.findAllUser();
    }
}
