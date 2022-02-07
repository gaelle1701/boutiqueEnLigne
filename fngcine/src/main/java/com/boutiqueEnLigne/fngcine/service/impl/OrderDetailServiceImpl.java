package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.repository.OrderDetailRepository;
import com.boutiqueEnLigne.fngcine.repository.OrderRepository;
import com.boutiqueEnLigne.fngcine.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByUser(Long userId) {
        List<OrderDetail> orderDetailList = orderDetailRepository.findAll();
        List<OrderDetail> orderDetailListByUser = new ArrayList<>();
        for (OrderDetail orderDetail: orderDetailList) {
            if (orderDetail.getUserId() == userId){
                orderDetailListByUser.add(orderDetail);
            }
        }
        return  orderDetailListByUser;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetail(Long orderDetailId) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(orderDetailId);
        OrderDetail orderDetail = null;
        if (optionalOrderDetail.isPresent()){
            orderDetail = optionalOrderDetail.get();
        }
        return orderDetail;
    }

}