package com.chipmunk.dao;

import com.chipmunk.model.view.Message;
import com.chipmunk.utils.DBUtil;

import java.util.List;

public class MessageDaoImpl extends DBUtil implements MessageDao {
    @Override
    public List<Message> getmessage(int image_id) {
        String sql = "select user_name,message,message_time from tb_message  inner join tb_user on tb_message.user_id=tb_user.user_id where tb_message.image_id=?";

        return super.executeQueryList(sql, Message.class, image_id);
    }

    @Override
    public int addmessage(Message message) {

        String sql = "insert into tb_message value(default,?,?,?,now())";
        return super.executeUpdate(sql, message.getUser_id(), message.getImage_id(), message.getMessage());
    }
}
