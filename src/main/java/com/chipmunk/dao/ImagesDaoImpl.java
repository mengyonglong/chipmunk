package com.chipmunk.dao;

import com.chipmunk.model.Images;
import com.chipmunk.utils.DBUtil;

import java.awt.*;
import java.util.List;

/**
 * @ClassName: ImagesDaoImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/10  10:42
 */
public class ImagesDaoImpl extends DBUtil implements ImagesDao {
    @Override
    public List<Images> queryImages() {
        String sql = "select * from tb_chipmunk";
        return super.executeQueryList(sql, Images.class);
    }

    @Override
    public Images QueryMessage(int image_id) {
        String sql = "select * from tb_chipmunk where image_id=?";

        return super.executeQueryOne(sql, Images.class, image_id);
    }

    @Override
    public List<Images> QueryTagImages(String tag) {
        String sql = "select * from tb_chipmunk where image_tag=?";
        return super.executeQueryList(sql, Images.class, tag);
    }


}
