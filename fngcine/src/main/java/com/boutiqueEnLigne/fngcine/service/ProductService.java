package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.Product;

import java.util.List;

public interface ProductService {
    void deleteProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Long id);
    List<Product>getProducts();
    List<Product> getProductsByGenre(String genre);
}
