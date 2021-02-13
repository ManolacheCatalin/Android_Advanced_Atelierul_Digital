package com.app.shopwithus.presentation.ui.products;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.ProductsUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ProductsViewModel extends ViewModel {

    private List<Product> items;
    private final ProductsUseCase productsUseCase;
    private MutableLiveData<String> argv;
    public ProductsViewModel(ProductsUseCase productsUseCase,MutableLiveData<String> argv){
        this.productsUseCase = productsUseCase;
        this.items = new ArrayList<>();
        this.argv=argv;
        argv.observeForever(argument->{
          getItems();
        });
    }

    public List<Product> getItems() {
        items.clear();
        items.addAll(productsUseCase.getItems(argv.getValue()));
        return items;
    }

    public MutableLiveData<String> getArgv() {
        return argv;
    }
}
