package com.chipmunk.servlet;

/**
 * @ClassName: SearchImages
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/16  11:02
 *    模糊查询
 */

import com.chipmunk.dao.SearchDao;
import com.chipmunk.dao.SearchDaoImpl;
import com.chipmunk.model.Search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchs")
public class SearchImages extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取搜索栏的标签
        String sear = request.getParameter("searches");
        //从数据库获取对应的图片
        SearchDao searchDao = new SearchDaoImpl();
        List<Search> S_images = searchDao.searchImages(sear);
        //判断能否搜索到用户输入的关键字进行查询，如果没有搜索到，返回主页。
        if (S_images.size() == 0) {
            response.setContentType("text/HTML;charset=utf-8");
            response.getWriter().write("<script>alert('查无此结果，请重新输入!');location.href='query';</script>");

        } else {
            //搜索到了，进行分类查询，获取分类的数据库图片。
            request.setAttribute("imagesLists", S_images);
            request.getRequestDispatcher("query").forward(request, response);
        }
    }
}

