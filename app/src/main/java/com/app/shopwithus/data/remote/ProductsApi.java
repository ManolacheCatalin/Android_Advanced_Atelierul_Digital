package com.app.shopwithus.data.remote;

import com.app.shopwithus.data.model.Order;
import com.app.shopwithus.data.model.Product;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductsApi {
    @GET("products")
    Call<List<Product>> getProductsByCategory(@Query("q") String productCategory);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("orders")
    Call<ResponseBody> sendOrder(@Body Map<String, String> params);
    @Headers({
            "Content-Type:application/json"
    })
    @POST("/orders")
    Call<Order> sendOrder(@Body Order order);
}
