package com.app.shopwithus.data.model;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("quantity")
    private Integer quntity;
    @SerializedName("productId")
    private String productid;
    @SerializedName("price")
    private Double price;
    @SerializedName("total")
    private Double total;
    public Order(Double total,Integer quantity,Double price,String productId){
    this.quntity=quantity;
    this.productid=productId;
    this.price=price;
    this.total=total;
    }

    public Double getTotal() {
        return total;
    }

    public String getProductid(){
        return productid;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quntity;
    }
}
