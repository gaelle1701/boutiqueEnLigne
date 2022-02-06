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
    public Order createOrder(Order order) {
        try{
            Order newOrder = orderRepository.save(order);
            System.out.println("new order in service -----------> " + newOrder);
            return newOrder;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
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
    public List<Order> getOrdersByUser(Long userId) {
        List<Order> orderList = new ArrayList<Order>();
        List<Order> orders = getOrders();
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isPresent()) {
            for (Order order: orders) {
                if (order.getUser().getId() == optionalUser.get().getId()) {
                    orderList.add(order);
                }
            }
        }
        return orderList;
    }

}
