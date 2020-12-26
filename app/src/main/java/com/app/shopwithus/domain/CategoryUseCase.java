package com.app.shopwithus.domain;

import androidx.lifecycle.MutableLiveData;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.generated.callback.OnClickListener;

import java.util.List;

public class CategoryUseCase {

    private final CategoryMediator categoryMediator;
    public CategoryUseCase(CategoryMediator categoryMediator){
        this.categoryMediator = categoryMediator;
    }

    public MutableLiveData<List<Category>> getList() {
        return categoryMediator.getList();
    }
}
