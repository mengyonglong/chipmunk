package com.chipmunk.servlet;

import com.chipmunk.dao.CollectDao;
import com.chipmunk.dao.CollectDaoImpl;
import com.chipmunk.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: DeleteImages
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/17  9:22
 */
@WebServlet("/delete")
public class DeleteImages extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageId = req.getParameter("image_id");
        int ImageId = Integer.parseInt(imageId);
        User user = (User) req.getSession().getAttribute("user");
        CollectDao collectDao = new CollectDaoImpl();
        int num = collectDao.DeleteImages(ImageId, user.getUser_id());

        resp.sendRedirect("querycollect");

    }
}
