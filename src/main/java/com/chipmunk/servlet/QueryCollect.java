package com.chipmunk.servlet;

import com.chipmunk.dao.CollectDao;
import com.chipmunk.dao.CollectDaoImpl;
import com.chipmunk.model.User;
import com.chipmunk.model.view.CollectView;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: QueryCollect
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  19:00
 */
@WebServlet("/querycollect")
public class QueryCollect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得登录用户对象
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.setContentType("text/HTML;charset=utf-8");
            response.getWriter().write("<script>alert('请您登录后进行操作!');location.href='query';</script>");
        }
        CollectDao collectDao = new CollectDaoImpl();
        //调用方法去查询当前用户收藏夹信息
        List<CollectView> collectViewList = collectDao.queryCollect(user.getUser_id());


        //存入到请求对象中
        request.setAttribute("collectViewList", collectViewList);

        //转发到  showCollect.jsp页面
        request.getRequestDispatcher("query");
        request.getRequestDispatcher("showCollect.jsp").forward(request, response);

    }
}
