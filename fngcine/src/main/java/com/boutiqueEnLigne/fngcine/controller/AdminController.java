package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.service.OrderDetailService;
import com.boutiqueEnLigne.fngcine.service.OrderService;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import com.boutiqueEnLigne.fngcine.validation.AuthentificationValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailService orderDetailService;

    // -------------------------------- ADMIN MANAGE PRODUCTS -------------------------------------- //

    @PostMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, AuthentificationValidation authentificationValidation) {
        if(authentificationValidation.isAdmin()){
            Product newProduct = productService.createProduct(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product productToUpdate, AuthentificationValidation authentificationValidation){
        if(authentificationValidation.isAdmin()){
        Product updatedProduct = productService.updateProduct(productToUpdate);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProductById(@PathVariable("id") Long id, AuthentificationValidation authentificationValidation) {
        if(authentificationValidation.isAdmin()){
        productService.deleteProduct(id);
        } else {
           ResponseEntity.status(HttpStatus.FORBIDDEN);
        }
    }

}
