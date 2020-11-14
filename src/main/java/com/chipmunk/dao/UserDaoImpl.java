package com.chipmunk.dao;

import com.chipmunk.model.User;
import com.chipmunk.utils.DBUtil;
import com.chipmunk.utils.MD5utils;

public class UserDaoImpl extends DBUtil implements UserDao {
    @Override
    //   注册
    public int userRegister(User user) {
        String sql = "insert into tb_user value(default,?,?,?,?,?)";
        return super.executeUpdate(sql, user.getUser_name(), user.getUser_password(), user.getUser_sex(), user.getUser_hobby(), user.getUser_phone());

    }

    @Override
    //   登录
    public User userLogin(String user_name, String user_password) {
        String sql = "select user_id user_name from tb_user where user_name=? and user_password=?";
        return super.executeQueryOne(sql, User.class, user_name, MD5utils.code(user_password));
    }
}
