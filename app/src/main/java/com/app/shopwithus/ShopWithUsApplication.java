package com.app.shopwithus;

import android.app.Application;
import android.widget.Toast;

import com.app.shopwithus.presentation.ui.detail.ProductHelp;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.TooManyListenersException;

import okhttp3.OkHttpClient;

//Entry point fot the application
public class ShopWithUsApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder().addInterceptor(new StethoInterceptor()).build();

    }

}
