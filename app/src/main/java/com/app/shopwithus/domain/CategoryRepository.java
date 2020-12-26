package com.app.shopwithus.domain;

import com.app.shopwithus.data.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getItems();
}
