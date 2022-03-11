package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.repository.ProductRepository;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = null;
        if (productOptional.isPresent()) {
            product = productOptional.get();
            productRepository.delete(product);
        }
    }

    @Override
    public Product createProduct(Product product) {
        try{
            Product newProduct = productRepository.save(product);
            return newProduct;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        System.out.println(product);
        if(product.isPresent()){
            return product.get();
        }
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByGenre(String genre) {
        List<Product> productList = productRepository.findAll();
        List<Product> productListByGenre = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getGenre().contains(genre)){
                productListByGenre.add(product);
            }
        }
        return  productListByGenre;
    }

}

