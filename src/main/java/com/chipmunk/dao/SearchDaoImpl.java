package com.chipmunk.dao;

/**
 * @ClassName: SearchDaoImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/16  11:04
 */

import com.chipmunk.model.Search;
import com.chipmunk.utils.DBUtil;

import java.util.List;

public class SearchDaoImpl extends DBUtil implements SearchDao {
    @Override
    public List<Search> searchImages(String tag) {

        String sql = "select * from tb_chipmunk  where  search_tag like concat('%',?,'%')";
        return super.executeQueryList(sql, Search.class, tag);
    }
}
