package com.chipmunk.dao;

import com.chipmunk.model.view.Message;

import java.util.List;

public interface MessageDao {
    //从数据库中获取评论
    public List<Message> getmessage(int image_id);

    //往数据库中导入评论
    public int addmessage(Message message);
}
