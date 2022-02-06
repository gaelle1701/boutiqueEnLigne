package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.repository.OrderRepository;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.service.OrderDetailService;
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
    @Autowired
    private OrderDetailService orderDetailService;


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
        List<OrderDetail> orderDetailList = orderDetailService.getOrderDetailsByUser(order.getUserId());
        List<OrderDetail> newOrderDetailList = new ArrayList<>();
        Order newOrder = new Order();
            for (OrderDetail orderDetail: orderDetailList) {
                if (orderDetail.isStatus()==false){
                    orderDetail.setStatus(true);;
                    orderDetailService.updateOrderDetail(orderDetail);
                    newOrderDetailList.add(orderDetail);
                }
                order.setOrderDetailList(newOrderDetailList);
            }
            if (newOrderDetailList != null) {
                System.out.println("Order créée ============================> " + newOrder);
                orderRepository.save(order);
            }
            return newOrder;
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
    public List<Order> getOrdersByUser(Long userId) {
        List<Order> orderList = new ArrayList<Order>();
        List<Order> orders = orderRepository.findAll();
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            for (Order order: orders) {
                if (order.getUserId() == optionalUser.get().getId()){
                    orderList.add(order);
                }
            }
        }
        return orderList;
    }

/*    @Override
    public Order addOrderDetailToOrder(Long id, OrderDetail orderDetail) {
        Optional<Order> currentOrder = orderRepository.findById(id);
        Order updatedOrder = null;
        if(currentOrder.isPresent()) {
            updatedOrder = currentOrder.get();
            updatedOrder.getOrderDetailList().add(orderDetail);
            orderDetailRepository.save(orderDetail);
            orderRepository.save(updatedOrder);
        }
        return updatedOrder;
    }*/
}
