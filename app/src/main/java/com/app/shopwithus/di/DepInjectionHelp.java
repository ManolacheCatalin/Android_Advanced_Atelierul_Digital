package com.app.shopwithus.di;

import com.app.shopwithus.data.remote.ServerFetchProducts;
import com.app.shopwithus.domain.ProductsMediator;
import com.app.shopwithus.domain.ProductsUseCase;

public class DepInjectionHelp {

    private static DepInjectionHelp instance;
    private final ProductsUseCase productsUseCase;
    private final ProductsMediator productsMediator;
    private final ServerFetchProducts serverFetchProducts;

    public DepInjectionHelp(){
       serverFetchProducts=new ServerFetchProducts();
       productsMediator=new ProductsMediator(serverFetchProducts);
       productsUseCase=new ProductsUseCase(productsMediator);
    }

    public static DepInjectionHelp getInstance() {
        if(instance==null){
            instance=new DepInjectionHelp();
        }
        return instance;
    }

    public ProductsMediator getProductsMediator() {
        return productsMediator;
    }

    public ProductsUseCase getProductsUseCase() {
        return productsUseCase;
    }

    public ServerFetchProducts getServerFetchProducts() {
        return serverFetchProducts;
    }
}
