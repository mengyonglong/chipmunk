package com.chipmunk.servlet;

import com.chipmunk.dao.CollectDao;
import com.chipmunk.dao.CollectDaoImpl;
import com.chipmunk.dao.UserDao;
import com.chipmunk.dao.UserDaoImpl;
import com.chipmunk.model.User;
import com.chipmunk.model.view.CollectView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/*
*   实现登录操作
* */
@WebServlet("/login")
public class Login extends HttpServlet   {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        //获取账号密码

        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");
        //处理对比数据库中密码
        UserDao userdao = new UserDaoImpl();
        User user = userdao.userLogin(user_name, user_password);
        //登录成功，查到对象
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            CollectDao collectDao = new CollectDaoImpl();
            //调用方法去查询当前用户收藏夹信息
            List<CollectView> collectViewList = collectDao.queryCollect(user.getUser_id());
            request.setAttribute("collectViewListCount", collectViewList.size());
            request.getRequestDispatcher("query").forward(request, response);
        } else {
            response.setContentType("text/HTML;charset=utf-8");
            response.getWriter().write("<script>alert('用户名或密码输入错误，请重新输入');location.href='/Chipmunk/login.jsp';</script>");
        }

    }
}
