package com.app.shopwithus.data.model;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

import java.io.File;

public class Category {

    private String categoryName;
    private Drawable drawable;

    public Category(String categoryName,Drawable drawable) {
        this.categoryName = categoryName;
        this.drawable=drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
