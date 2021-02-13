package com.app.shopwithus.presentation.ui.detail;

import android.view.View;

import com.app.shopwithus.data.model.Product;

public interface SendOrderClick {
    public void confirm(Product product, View view);
}
