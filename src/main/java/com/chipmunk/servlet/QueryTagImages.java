package com.chipmunk.servlet;

import com.chipmunk.dao.CollectDao;
import com.chipmunk.dao.CollectDaoImpl;
import com.chipmunk.dao.ImagesDao;
import com.chipmunk.dao.ImagesDaoImpl;
import com.chipmunk.model.Images;
import com.chipmunk.model.User;
import com.chipmunk.model.view.CollectView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query_tag")
public class QueryTagImages extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端传来的tag标识符
        request.setCharacterEncoding("utf-8");
        String tag = request.getParameter("tag");
        User user = (User) request.getSession().getAttribute("user");
        //获取标识符所对应的图片
        ImagesDao imagesDao = new ImagesDaoImpl();
        CollectDao collectDao = new CollectDaoImpl();
        List<Images> imagesList = imagesDao.QueryTagImages(tag);
        //调用方法去查询当前用户收藏夹信息
        if(user!=null){
            List<CollectView> collectViewList = collectDao.queryCollect(user.getUser_id());
            //存入到请求对象中
            request.setAttribute("collectViewList", collectViewList);
        }




        request.setAttribute("imagesLists", imagesList);
        //发送给首页
        request.getRequestDispatcher("query").forward(request, response);

    }
}
