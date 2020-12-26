package com.app.shopwithus.data.remote;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.domain.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class ServerFetchCategory extends CallServer<Category> implements CategoryRepository {

    private ServerInterface<Category> serverApi;
    private List<Category> list=new ArrayList<>();

    public ServerFetchCategory(){
        setApi(serverApi);
    }


    @Override
    public List<Category> getItems() {
        startCall();
        list.addAll(getItems());
        return list;
    }
}
