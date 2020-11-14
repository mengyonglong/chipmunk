package com.chipmunk.dao;

import com.chipmunk.model.User;

public interface UserDao {
    //登录
    public int userRegister(User user);

    //注册
    public User userLogin(String user_name, String user_password);
}
