package com.chipmunk.servlet;

import com.chipmunk.dao.ImagesDao;
import com.chipmunk.dao.ImagesDaoImpl;
import com.chipmunk.dao.MessageDao;
import com.chipmunk.dao.MessageDaoImpl;
import com.chipmunk.model.Images;
import com.chipmunk.model.view.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/details")
public class QueryMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图片信息
        String imageid = request.getParameter("ImageId");
        Integer image_id = Integer.parseInt(imageid);

        //处理图片信息
        ImagesDao imagesDao = new ImagesDaoImpl();
        Images images = imagesDao.QueryMessage(image_id);

        //发送图片信息
        request.setAttribute("images", images);

        //从数据库获取评论信息
        MessageDao messageDao = new MessageDaoImpl();
        List<Message> messages = messageDao.getmessage(image_id);//每个message方发种含有  user_name message(消息) message_time
        request.setAttribute("messages", messages);
        //请求转发  转发到首页
        request.getRequestDispatcher("details.jsp").forward(request, response);
    }
}
