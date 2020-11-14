package com.chipmunk.model;

/**
 * @ClassName: Collect
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  17:18
 * 收藏夹
 */
public class Collect {

    private Integer image_id;
    private String image_address;
    private Integer user_id;

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImage_address() {
        return image_address;
    }

    public void setImage_address(String image_address) {
        this.image_address = image_address;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "image_id=" + image_id +
                ", image_address='" + image_address + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
