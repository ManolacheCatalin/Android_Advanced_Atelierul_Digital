package com.app.shopwithus.presentation.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.CategoryUseCase;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {

    private List<Category> list=new ArrayList<>();
    private final CategoryUseCase categoryUseCase;
    public CategoryViewModel(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    public List<Category> getItems() {
        list.addAll(categoryUseCase.getItems());
        return list;
    }

}