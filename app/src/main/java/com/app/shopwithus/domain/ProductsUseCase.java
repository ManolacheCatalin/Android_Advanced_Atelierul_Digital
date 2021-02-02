package com.app.shopwithus.domain;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProductsUseCase {
    private final ProductsMediator productsMediator;
    private List<Product> items;

    public ProductsUseCase(ProductsMediator productsMediator) {
        this.productsMediator = productsMediator;
        this.items=new ArrayList<>();
    }

    public List<Product> getItems(String argv) {
        items.clear();
        items.addAll(productsMediator.getItems(argv));
        return items;
    }
}
