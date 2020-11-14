package com.chipmunk.model;

public class Search {
    private Integer image_id;
    private String image_tag;
    private String image_address;

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

    public String getSearch_tag() {
        return search_tag;
    }

    public void setSearch_tag(String search_tag) {
        this.search_tag = search_tag;
    }

    private String search_tag;

}
