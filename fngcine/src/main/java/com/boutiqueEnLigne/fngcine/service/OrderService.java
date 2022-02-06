package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Long id);
    List<Order> getOrders();
    List<Order> getOrdersByUser(Long id);
}
