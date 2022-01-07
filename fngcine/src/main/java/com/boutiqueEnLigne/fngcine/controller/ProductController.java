package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    ResponseEntity responseEntity;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String genre) {
        List<Product> products;
        if (genre != null)  {
            products = productService.getProductsByGenre(genre);
        } else {
            products = productService.getProducts();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

/*
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Product>> getProductsByGenre(@PathVariable("genre") String genre) {
            List<Product> productList = productService.getProductsByGenre(genre);
            return new ResponseEntity<>(productList, HttpStatus.OK);
    }*/

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            Product newProduct = productService.createProduct(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product productToUpdate){
            Product updatedProduct = productService.updateProduct(productToUpdate);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
