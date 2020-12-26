package com.app.shopwithus.data.remote;

import com.app.shopwithus.data.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductsApi {
    @GET("products.json")
    Call<List<Product>> getItemsFromServer();
    @GET("products.json")
    Call<Product> getProductById(@Query("productId") String productId);
    @GET("products.json")
    Call<List<Product>> getProductsByCategory(@Query("productCategory") String productCategory);

}
