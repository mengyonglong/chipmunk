package com.chipmunk.model;

import javax.xml.soap.SAAJResult;

/**
 * @ClassName: Images
 * @Description: TODO
 * @author: meyolo
 * @date: 2020/10/10  10:42
 * 图片类
 */
public class Images {
    private Integer image_id;
    private String image_tag;
    private String image_address;
    private String search_tag;

    public String getSearch_tag() {
        return search_tag;
    }

    public void setSearch_tag(String search_tag) {
        this.search_tag = search_tag;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImage_tag() {
        return image_tag;
    }

    public void setImage_tag(String image_tag) {
        this.image_tag = image_tag;
    }

    public String getImage_address() {
        return image_address;
    }

    public void setImage_address(String image_address) {
        this.image_address = image_address;
    }

    @Override
    public String toString() {
        return "Images{" +
                "image_id=" + image_id +
                ", image_tag='" + image_tag + '\'' +
                ", image_address='" + image_address + '\'' +
                ", search_tag='" + search_tag + '\'' +
                '}';
    }
}
