package com.myspring.mespring.proxy.staticproxy;

import java.util.List;

/**
 * Created by zhuran on 2019/1/8 0008
 */
public interface IUser {
    List<String> findAllUser();
    int deleteUser(int id);
    int saveUser(String userName);
}
