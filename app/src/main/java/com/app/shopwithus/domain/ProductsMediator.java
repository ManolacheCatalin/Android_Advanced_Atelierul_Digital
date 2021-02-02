package com.app.shopwithus.domain;

import android.util.Log;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.data.remote.ServerFetchProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductsMediator {

    private ServerFetchProducts serverFetchProducts;
    private List<Product> items;

    public ProductsMediator(ServerFetchProducts serverFetchProducts) {
        this.serverFetchProducts = serverFetchProducts;
        this.items = new ArrayList<>();
    }

    public List<Product> getItems(String argv) {
        items.clear();
        items.addAll(serverFetchProducts.getProducts(argv));
        return items;
    }
}
