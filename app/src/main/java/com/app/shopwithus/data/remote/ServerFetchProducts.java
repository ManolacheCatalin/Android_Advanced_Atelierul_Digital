package com.app.shopwithus.data.remote;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.ProductsRepository;

import java.util.ArrayList;
import java.util.List;

public class ServerFetchProducts extends CallServer<Product> implements ProductsRepository {

    private List<Product> list=new ArrayList<>();
    private ServerInterface<Product> serviceApi;

    public ServerFetchProducts(){
        setApi(serviceApi);
    }

    @Override
    public List<Product> getProducts() {startCall();
      list.addAll(getList());
      return list;
    }
}
