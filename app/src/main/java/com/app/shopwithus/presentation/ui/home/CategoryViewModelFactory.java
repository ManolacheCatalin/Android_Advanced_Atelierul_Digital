package com.app.shopwithus.presentation.ui.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.domain.CategoryUseCase;

public class CategoryViewModelFactory implements ViewModelProvider.Factory {

    Context context;
    public CategoryViewModelFactory(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new CategoryViewModel(new CategoryUseCase(context));
    }
}
