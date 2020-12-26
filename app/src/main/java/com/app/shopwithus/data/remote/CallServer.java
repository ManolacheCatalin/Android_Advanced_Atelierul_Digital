package com.app.shopwithus.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class CallServer<T>{

    protected String BaseUrl="http://192.168.100.90:3000/";
    protected List<T> list;
    protected ServerInterface<T> serviceApi;

    protected void setApi(ServerInterface<T> serviceApi){
        this.serviceApi=serviceApi;
    }

    protected void startCall(){
        Gson gsGson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient okHttpClient=new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gsGson))
                .build();
        serviceApi=retrofit.create(ServerInterface.class);
        Call<List<T>> call= (Call<List<T>>) serviceApi.getItems();
        call.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(Call<List<T>> call, Response<List<T>> response) {
                if(response.isSuccessful()) {list.addAll(response.body());}
            }

            @Override
            public void onFailure(Call<List<T>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public List<T> getList() {
        return list;
    }
}
