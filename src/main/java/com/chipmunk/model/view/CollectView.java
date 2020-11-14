package com.chipmunk.model.view;

/**
 * @ClassName: CollectView
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/13  18:48
 * <p>
 * 收藏夹的视图类
 */
public class CollectView {
    private Integer collects_id;
    private String image_address;
    private Integer image_id;

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Integer getCollects_id() {
        return collects_id;
    }

    public void setCollects_id(Integer collects_id) {
        this.collects_id = collects_id;
    }

    public String getImage_address() {
        return image_address;
    }

    public void setImage_address(String image_address) {
        this.image_address = image_address;
    }

    @Override
    public String toString() {
        return "CollectView{" +
                "collects_id=" + collects_id +
                ", image_address='" + image_address + '\'' +
                ", image_id=" + image_id +
                '}';
    }
}
