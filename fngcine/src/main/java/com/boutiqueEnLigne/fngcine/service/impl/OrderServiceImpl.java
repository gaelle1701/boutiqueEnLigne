package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.repository.OrderRepository;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = null;
        if (orderOptional.isPresent()) {
            order = orderOptional.get();
            orderRepository.delete(order);
        }
    }

    @Override
    public Order createOrder(Order order) {
        try{
            Order newOrder = orderRepository.save(order);
            return newOrder;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get().getOrdersList();
    }
}
