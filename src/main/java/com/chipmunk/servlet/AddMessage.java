package com.chipmunk.servlet;

import com.chipmunk.dao.MessageDao;
import com.chipmunk.dao.MessageDaoImpl;
import com.chipmunk.model.User;
import com.chipmunk.model.view.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录后评论
 */
@WebServlet("/add_message")
public class AddMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从会话对象获取用户信息
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        //获取评论
        String message = request.getParameter("message");
        //获取图片编号（使用地址传值）
        String imageids = request.getParameter("ImageId");
        int image_id = Integer.parseInt(imageids);

        //处理信息，并将信息导入数据库
        Message messages = new Message();
        messages.setUser_id(user_id);
        messages.setMessage(message);
        messages.setImage_id(image_id);


        MessageDao messageDao = new MessageDaoImpl();
        int jub = messageDao.addmessage(messages);


        if (jub > 0) {
            response.sendRedirect("details?ImageId=" + image_id);
        } else {
            System.out.println("提交评论错误");
            response.sendRedirect("details?ImageId=" + image_id);
        }
    }
}
