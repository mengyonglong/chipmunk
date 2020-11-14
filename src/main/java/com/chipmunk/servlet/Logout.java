package com.chipmunk.servlet;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: Logout
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/17  19:42
 *    用户注销
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除用户session
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("query");
    }
}
