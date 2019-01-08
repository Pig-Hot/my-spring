package com.myspring.mespring.proxy.staticproxy;

import java.util.List;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public class UserProxyImpl implements IUser {

    private IUser iUser;

    public UserProxyImpl(IUser iUser){
        this.iUser = iUser;
    }

    @Override
    public List<String> findAllUser() {
        beforeLog();
        iUser.findAllUser();
        afterLog();
        return null;
    }

    @Override
    public int deleteUser(int id) {
        beforeLog();
        iUser.deleteUser(id);
        afterLog();
        return 0;
    }

    @Override
    public int saveUser(String userName) {
        beforeLog();
        iUser.saveUser(userName);
        afterLog();
        return 0;
    }

    private void beforeLog() {
        System.out.println("开始执行");
    }

    private void afterLog() {
        System.out.println("执行完毕");
    }
}
