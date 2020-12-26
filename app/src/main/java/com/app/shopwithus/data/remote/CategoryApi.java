package com.app.shopwithus.data.remote;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.generated.callback.OnClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {
    @GET("/Category.json")
    Call<List<Category>> getItemsFromServer();
}
