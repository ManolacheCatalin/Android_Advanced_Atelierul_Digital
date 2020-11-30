package com.app.shopwithus.model;

import androidx.annotation.NonNull;
//Product class for handling json objects
public class Product {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private Double starRating;
    private String productCategory;
    private String productShortDescription;
    private String productCaracteristics;
    private String productDescription;
    private String vendor;
    private boolean favourite;
    public Product(Integer productId,String productName,String productDescription,String productShortDescription,String productCaracteristics,String productCategory,Double productPrice,Double starRating,String vendor,boolean favourite){
    this.productName=productName;
    this.productPrice=productPrice;
    this.starRating=starRating;
    this.productCategory=productCategory;
    this.productDescription=productDescription;
    this.vendor=vendor;
    this.productId=productId;
    this.favourite=favourite;
    this.productShortDescription=productShortDescription;
    this.productCaracteristics=productCaracteristics;
    }

    public Double getProductPrice() {
        return productPrice;
    }
    public Double getStarRating() {
        return starRating;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public Integer getProductId() {
        return productId;
    }
    public String getProductCaracteristics() {
        return productCaracteristics;
    }
    public String getProductShortDescription() {
        return productShortDescription;
    }
    public void setProductCaracteristics(String productCaracteristics) {
        this.productCaracteristics = productCaracteristics;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }
    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
