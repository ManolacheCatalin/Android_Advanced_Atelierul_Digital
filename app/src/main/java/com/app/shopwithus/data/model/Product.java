package com.app.shopwithus.data.model;


import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("productId")
    private String productId;
    @SerializedName("productName")
    private String productName;
    @SerializedName("productPrice")
    private Double productPrice;
    @SerializedName("starRating")
    private Double starRating;
    @SerializedName("productCategory")
    private String productCategory;
    @SerializedName("productShortDescription")
    private String productShortDescription;
    @SerializedName("productDescription")
    private String productDescription;
    @SerializedName("vendor")
    private String vendor;
    @SerializedName("imageUrl")
    private byte[] imageRes;
    @SerializedName("favourite")
    private boolean favourite;

    public Product(String productId, String productName, String productDescription, String productShortDescription, String productCategory, Double productPrice, Double starRating, String vendor, boolean favourite, byte[] imageRes) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.starRating = starRating;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.vendor = vendor;
        this.productId = productId;
        this.favourite = favourite;
        this.productShortDescription = productShortDescription;
        this.imageRes=imageRes;
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

    public String getProductId() {
        return productId;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public byte[] getImageRes() {
        return imageRes;
    }

    public void setImageRes(byte[] imageRes) {
        this.imageRes = imageRes;
    }
}
