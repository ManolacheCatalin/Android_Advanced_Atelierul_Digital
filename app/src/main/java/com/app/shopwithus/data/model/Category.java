package com.app.shopwithus.data.model;

import android.content.Intent;

public class Category {

    private Integer categoryId;
    private String categoryName;
    private boolean favourite;
    private String urlImage;

    public Category(Integer categoryId, String categoryName, boolean favourite, String urlImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.favourite = favourite;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public boolean isFavourite() {
        return favourite;
    }
}
