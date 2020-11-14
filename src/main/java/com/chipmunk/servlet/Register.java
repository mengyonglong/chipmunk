package com.chipmunk.servlet;

import com.chipmunk.dao.UserDao;
import com.chipmunk.dao.UserDaoImpl;
import com.chipmunk.model.User;
import com.chipmunk.utils.MD5utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        用户类，用于接收数据
        User user = new User();

//        获取数据
        String user_name = request.getParameter("user_name");
//        采用MD5加密对密码进行加密
        String user_password = MD5utils.code(request.getParameter("user_password"));
        String user_sex = request.getParameter("user_sex");
        String[] user_hobby = request.getParameterValues("user_hobby");
        String user_phone = request.getParameter("user_phone");
        StringBuffer buffer = new StringBuffer();

        for (String hobby : user_hobby) {
            buffer.append(hobby);
            buffer.append(",");
        }
        buffer.delete(buffer.length() - 1, buffer.length());


//        放入用户对象
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        user.setUser_phone(user_phone);
        user.setUser_sex(user_sex);
        user.setUser_hobby(buffer.toString());

//        导入数据库
        UserDao userDao = new UserDaoImpl();
        int num = userDao.userRegister(user);
        if (num > 0) {
            response.sendRedirect("login.jsp");
        }
    }
}
