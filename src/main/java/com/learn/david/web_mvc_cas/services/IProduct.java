package com.learn.david.web_mvc_cas.services;

import com.learn.david.web_mvc_cas.entities.Product;

import java.util.List;

public interface IProduct {
    void addProduct(Product product);
    List<Product> getProducts();
}
