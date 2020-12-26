package com.app.shopwithus.domain;

import androidx.lifecycle.MutableLiveData;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.data.remote.ServerFetchCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CategoryMediator {

    private final ExecutorService executorService;
    private ServerFetchCategory serverFetchCategory;
    private MutableLiveData<List<Category>> listMutableLiveData=new MutableLiveData<>();
    public CategoryMediator(ServerFetchCategory serverFetchCategory){
        executorService = Executors.newSingleThreadExecutor();
        this.serverFetchCategory=serverFetchCategory;
    }

    public MutableLiveData<List<Category>> getList() {
        ArrayList<Category> temp=new ArrayList<>();
        executorService.execute(() -> {
          temp.addAll(serverFetchCategory.getItems());
        });
        listMutableLiveData.postValue(temp);
        return listMutableLiveData;
    }
}
