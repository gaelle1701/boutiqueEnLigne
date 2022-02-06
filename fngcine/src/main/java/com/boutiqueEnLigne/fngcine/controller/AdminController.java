package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.service.OrderService;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // -------------------------------- USER -------------------------------------- //

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/users/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User userToUpdate){
        Long id = userToUpdate.getId();
        User user = userService.getUserById(id);
        String password = user.getPassword();
        userToUpdate.setPassword(password);
        User updatedUser = userService.updateUser(userToUpdate);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUserById(@PathVariable("userId") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUserById(id);
    }

    // -------------------------------- ORDER -------------------------------------- //

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orderList = orderService.getOrders();
        return ResponseEntity.ok(orderList);
    }

    // -------------------------------- PRODUCT -------------------------------------- //

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product productToUpdate){
        Product updatedProduct = productService.updateProduct(productToUpdate);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
