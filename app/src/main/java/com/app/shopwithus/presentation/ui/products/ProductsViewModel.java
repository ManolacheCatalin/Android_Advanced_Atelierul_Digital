package com.app.shopwithus.presentation.ui.products;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.ProductsUseCase;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewModel extends ViewModel {

    private List<Product> items;
    private final ProductsUseCase productsUseCase;
    String argv;
    public ProductsViewModel(ProductsUseCase productsUseCase,String argv){
        this.productsUseCase = productsUseCase;
        this.items = new ArrayList<>();
        this.argv=argv;
    }

    public List<Product> getItems() {
        items.clear();
        items.addAll(productsUseCase.getItems(argv));
        return items;
    }
}
