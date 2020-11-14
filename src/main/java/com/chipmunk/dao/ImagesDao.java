package com.chipmunk.dao;

import com.chipmunk.model.Images;

import java.util.List;

/**
 * @ClassName: ImagesDao
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/10  10:42
 * 获得图片数据
 */
public interface ImagesDao {
    //查询所有图书信息
    public List<Images> queryImages();

    public Images QueryMessage(int image_id);

    public List<Images> QueryTagImages(String tag);


}
