package com.app.shopwithus.domain;

import androidx.lifecycle.MutableLiveData;

import com.app.shopwithus.data.model.User;

public class ProductsUseCase {
    private final ProductsMediator productsMediator;

    public ProductsUseCase(ProductsMediator productsMediator) {
        this.productsMediator = productsMediator;
    }

}
