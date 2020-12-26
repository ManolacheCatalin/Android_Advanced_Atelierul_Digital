package com.app.shopwithus.presentation.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.data.remote.ServerFetchCategory;
import com.app.shopwithus.domain.CategoryMediator;
import com.app.shopwithus.domain.CategoryUseCase;

public class CategoryViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new CategoryViewModel(new CategoryUseCase(new CategoryMediator(new ServerFetchCategory())));
    }
}
