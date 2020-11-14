package com.chipmunk.dao;

import com.chipmunk.model.Collect;
import com.chipmunk.model.Images;
import com.chipmunk.model.view.CollectView;
import com.chipmunk.utils.DBUtil;

import java.util.List;

/**
 * @ClassName: CarDaoImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  17:22
 */
public class CollectDaoImpl extends DBUtil implements CollectDao {

    /*
    * 添加收藏照片
    * */
    @Override
    public int addCollect(Collect collect) {
        String sql = "insert into tb_collect values(default,?,?)";
        return super.executeUpdate(sql, collect.getUser_id(), collect.getImage_id());
    }
    /*
    *   查询收藏照片
    * */

    @Override
    public List<CollectView> queryCollect(int userid) {
        String sql = "SELECT chipmunk.image_address,chipmunk.image_id FROM tb_chipmunk chipmunk INNER JOIN tb_collect collect on chipmunk.image_id=collect.image_id  WHERE collect.user_id=?";
        return super.executeQueryList(sql, CollectView.class, userid);
    }

    /*
    *   收藏夹删除照片
    * */
    @Override
    public int DeleteImages(int image_id, int user_id) {
        String sql = "delete from tb_collect where image_id=? and user_id=?";
        return super.executeUpdate(sql, image_id, user_id);
    }

}

