package com.chipmunk.servlet;

import com.chipmunk.dao.CollectDao;
import com.chipmunk.dao.CollectDaoImpl;
import com.chipmunk.model.Collect;
import com.chipmunk.model.User;
import com.chipmunk.model.view.CollectView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: AddCollect
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  17:35
 *
 *    加入收藏夹
 */
@WebServlet("/addCollect")
public class AddCollect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int imageId = Integer.parseInt(request.getParameter("ImageId"));
        Collect collect = new Collect();
        collect.setImage_id(imageId);

        User user = (User) request.getSession().getAttribute("user");
        //用户未登录
        if (user == null) {
            response.setContentType("text/HTML;charset=utf-8");
            response.getWriter().write("<script>alert('请登录后访问!');location.href='query';</script>");
        }
        collect.setUser_id(user.getUser_id());

        CollectDao collectDao = new CollectDaoImpl();
        int num = collectDao.addCollect(collect);
        //调用方法去查询当前用户收藏夹信息

        List<CollectView> collectViewList = collectDao.queryCollect(user.getUser_id());
        request.setAttribute("collectViewListCount", collectViewList.size());

      request.getRequestDispatcher("query").forward(request,response);


    }
}
