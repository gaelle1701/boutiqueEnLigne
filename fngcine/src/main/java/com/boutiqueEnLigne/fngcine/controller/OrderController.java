package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.service.OrderService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    ResponseEntity responseEntity;

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUser(@PathVariable("id") Long id) {
        return orderService.getOrdersByUser(id);
    }

    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id,@RequestBody Order orderToUpdate){
        Order updatedOrder = orderService.updateOrder(orderToUpdate);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

}
