package com.app.shopwithus.data.remote;

import android.util.Log;

import com.app.shopwithus.data.model.Order;
import com.app.shopwithus.data.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Important de retinut este ca schimbarile pe json-server nu sunt retirnute,stocate,deci nu putem simula o camanda reala
public class SendOrder {

    private String BaseUrl = "http://192.168.100.90:3001/";
    private ProductsApi api;
    boolean flag=false;

    public SendOrder(){

    }
    public void startCall(Order order){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Gson gsGson = new GsonBuilder()
               .setLenient()
               .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(okHttpClient)
               .addConverterFactory(GsonConverterFactory.create(gsGson))
                .build();
        api = retrofit.create(ProductsApi.class);
       Call<Order> call=api.sendOrder(order);
       call.enqueue(new Callback<Order>() {
           @Override
           public void onResponse(Call<Order> call, Response<Order> response) {

           }

           @Override
           public void onFailure(Call<Order> call, Throwable t) {

           }
       });
    }
    public HashMap<String,String> createMap(Order order){
       HashMap<String,String> map=new HashMap<>();
       map.put("quantity",order.getQuantity().toString());
       map.put("price",order.getPrice().toString());
       map.put("total",order.getTotal().toString());
       map.put("productId",order.getProductid());
       return map;
    }

    public boolean IsSuccess() {
        return flag;
    }
}
