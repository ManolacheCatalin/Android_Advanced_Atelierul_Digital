package com.app.shopwithus.presentation.ui.products;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.data.remote.ServerFetchProducts;
import com.app.shopwithus.domain.CategoryUseCase;
import com.app.shopwithus.domain.ProductsRepository;
import com.app.shopwithus.domain.ProductsUseCase;
import com.app.shopwithus.presentation.ui.home.CategoryViewModel;

public class ProductViewModelFactory  implements ViewModelProvider.Factory{

    private ProductsUseCase productsUseCase;
    private MutableLiveData<String> argv;
    public ProductViewModelFactory(ProductsUseCase productsUseCase,MutableLiveData<String> argv){
        this.productsUseCase=productsUseCase;
        this.argv=argv;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new ProductsViewModel(productsUseCase,argv);
    }
}
