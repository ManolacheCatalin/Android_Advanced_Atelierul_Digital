package com.app.shopwithus.domain;

import com.app.shopwithus.data.model.Product;

import java.util.List;

public interface ProductsRepository {
    List<Product> getProducts(String argv);

}
