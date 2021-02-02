package com.app.shopwithus.data.remote;

import android.util.Log;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.ProductsRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerFetchProducts implements ProductsRepository {

    private String BaseUrl = "http://192.168.100.90:3000/";
    private ProductsApi api;
    private List<Product> list;

    public ServerFetchProducts() {
        this.list = new ArrayList<>();
    }
    @Override
    public List<Product> getProducts(String argv) {
        Gson gsGson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gsGson))
                .build();
        api = retrofit.create(ProductsApi.class);
        Call<List<Product>> call = api.getProductsByCategory(argv);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    list.clear();
                    list.addAll(response.body());
                } else {
                    Log.d("DEBUG", "not success");
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return list;
    }
}
