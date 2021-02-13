package com.app.shopwithus.presentation.ui.detail;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.domain.CategoryUseCase;
import com.app.shopwithus.domain.OrderUseCase;
import com.app.shopwithus.presentation.ui.home.CategoryViewModel;

public class DetailViewModelFactory implements ViewModelProvider.Factory {
    private OrderUseCase orderUseCase;

    public DetailViewModelFactory(OrderUseCase orderUseCase){
        this.orderUseCase=orderUseCase;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return  (T)new DetailViewModel(orderUseCase);
    }
}
