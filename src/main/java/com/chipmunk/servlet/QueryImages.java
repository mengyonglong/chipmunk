package com.chipmunk.servlet;

import com.chipmunk.dao.*;
import com.chipmunk.model.Images;
import com.chipmunk.model.Search;
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
 * @ClassName: QueryImages
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/10  10:44
 */
@WebServlet("/query")
public class QueryImages extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImagesDao imagesDao = new ImagesDaoImpl();
        SearchDao searchDao = new SearchDaoImpl();
        String sear = req.getParameter("searches");
        List<Search> S_images = searchDao.searchImages(sear);
        String tagq = req.getParameter("tag");
        User user = (User) req.getSession().getAttribute("user");
        //判断是否进行了分类搜索，如果进行了分类搜索
        if (tagq != null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
            //判断是否进行了模糊查询，如果进行了模糊查询
        else if (S_images.size() != 0) {
            req.setAttribute("imagesLists", S_images);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
               /* 判断用户是否登录，如果登录了
               *      获取收藏夹的图片数据进行显示
               * */
        else if(user!=null) {
            CollectDao collectDao = new CollectDaoImpl();
            List<CollectView> collectViewList = collectDao.queryCollect(user.getUser_id());
            req.setAttribute("collectViewListCount", collectViewList.size());
            List<Images> imagesList = imagesDao.queryImages();
            req.setAttribute("imagesList", imagesList);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        }
        /*
             用户未登录  直接遍历所有图片
        * */
        else{
            List<Images> imagesList = imagesDao.queryImages();
            req.setAttribute("imagesList", imagesList);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
