package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    void deleteOrder(Long id);
    Order createOrder(Order order);
    Order updateOrder(Order order);
    Order getOrder(Long id);
    List<Order> getOrders();
    List<Order> getOrdersByUser(Long userId);}
