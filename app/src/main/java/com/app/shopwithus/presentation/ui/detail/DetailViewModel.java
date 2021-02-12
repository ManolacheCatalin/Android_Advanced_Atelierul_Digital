package com.app.shopwithus.presentation.ui.detail;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.app.shopwithus.data.model.Product;

public class DetailViewModel  extends ViewModel implements Oder {

    private Product product;

    public DetailViewModel(){

    }

    public Product getProduct() {
        product=ProductHelp.getInstance().getProduct();
        return product;
    }

    @Override
    public void order(Product product) {

    }
}
