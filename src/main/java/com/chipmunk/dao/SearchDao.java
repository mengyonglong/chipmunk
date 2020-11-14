package com.chipmunk.dao;

/**
 * @ClassName: SearchDao
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/16  11:03
 */

import com.chipmunk.model.Search;

import java.util.List;

public interface SearchDao {
    public List<Search> searchImages(String tag);
}
