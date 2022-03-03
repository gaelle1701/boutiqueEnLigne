package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.entity.Product;
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


    public static final float TVA = 20f;

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
        /*Long userId = authentificationValidation.getTokenUserId();
        System.out.println("userId ------------------> " + userId);
        User currentUser = userRepository.getById(userId);
        System.out.println("currentUser ---------------------> " + currentUser);
        order.setUser(currentUser);*/
        List<OrderDetail> orderDetailList = orderDetailService.getOrderDetailsByUser(order.getUser().getId());
        List<OrderDetail> newOrderDetailList = new ArrayList<>();
        Order newOrder = new Order();
        for (OrderDetail orderDetail: orderDetailList) {
            if (!orderDetail.isStatus()){
                orderDetail.setStatus(true);;
                orderDetailService.updateOrderDetail(orderDetail);
                newOrderDetailList.add(orderDetail);
            }
            order.setOrderDetailList(newOrderDetailList);
        }
        if (newOrderDetailList != null) {
            float totalPrice = countTotalPrice(newOrderDetailList);
            order.setTotalPrice(totalPrice);
            orderRepository.save(order);
        }
        System.out.println("Order créée ============================> " + newOrder);
        return newOrder;
    }

    private float countTotalPrice(List<OrderDetail> orderDetailList){
        float totalPrice= 0;
        float sumProductUnitPriceByQty= 0;
        for (OrderDetail orderDetail: orderDetailList) {
            float productUnitPriceByQty = orderDetail.getPriceByQty();
            sumProductUnitPriceByQty += productUnitPriceByQty;
        }
        totalPrice = (1+TVA/100) * sumProductUnitPriceByQty;
        return totalPrice;
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
                if (order.getUser().getId() == optionalUser.get().getId()){
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
