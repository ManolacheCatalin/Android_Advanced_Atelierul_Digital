package com.app.shopwithus.domain;

import com.app.shopwithus.data.remote.ServerFetchProducts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductsMediator {

    private final ExecutorService executorService;
    private ServerFetchProducts serverFetchProducts;
    public ProductsMediator(ServerFetchProducts serverFetchProducts) {
    this.executorService= Executors.newSingleThreadExecutor();
    this.serverFetchProducts=serverFetchProducts;
    }
}
