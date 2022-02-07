package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getOrderDetailsByUser(Long userId);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    OrderDetail getOrderDetail(Long orderDetailId);
}
