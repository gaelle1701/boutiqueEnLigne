package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.User;
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
    @Autowired
    private OrderDetailService orderDetailService;

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
        userService.deleteUserById(id);
    }

    //_______________ORDERS__________________

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

//    @GetMapping("/orders/{userId}")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<List<Order>> getOrdersByUserIdForAdmin(@PathVariable("userId") Long userId) {
//        List<Order> orderList = orderService.getOrdersByUser(userId);
//        return new ResponseEntity<>(orderList, HttpStatus.OK);
//    }

    //_______________ORDER DETAILS__________________

    @GetMapping("/order_details/{orderId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<OrderDetail>> getOrderDetailList(@PathVariable("orderId") long orderId) {
        List<OrderDetail> orderDetailList = orderDetailService.getOrderDetails(orderId);
        return new ResponseEntity<>(orderDetailList, HttpStatus.OK);
    }

    //_______________PRODUCTS__________________

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
