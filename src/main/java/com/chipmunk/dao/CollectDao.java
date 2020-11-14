package com.chipmunk.dao;

import com.chipmunk.model.Collect;
import com.chipmunk.model.view.CollectView;

import java.util.List;

/**
 * @ClassName: CollectDao
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  17:20
 * 收藏夹
 */
public interface CollectDao {
    //添加收藏方法
    public int addCollect(Collect collect);

    //根据编号查询收藏夹
    public List<CollectView> queryCollect(int userid);

    //删除收藏夹的照片,此处不做清空功能
    public int DeleteImages(int image_id, int user_id);
}
