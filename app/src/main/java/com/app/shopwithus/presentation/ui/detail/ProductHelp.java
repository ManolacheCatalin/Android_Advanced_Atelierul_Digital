package com.app.shopwithus.presentation.ui.detail;

import com.app.shopwithus.data.model.Product;

public class ProductHelp {
    private static ProductHelp instance;
    private  Product product;
    public ProductHelp(){

    }

    public static ProductHelp getInstance() {
        if(instance==null){
            instance=new ProductHelp();
        }
        return instance;
    }
    public void setProduct(Product product){
     this.product=product;
    }

    public Product getProduct() {
        return product;
    }
}
