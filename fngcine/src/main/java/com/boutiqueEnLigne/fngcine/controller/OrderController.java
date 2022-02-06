package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.*;
import com.boutiqueEnLigne.fngcine.service.OrderDetailService;
import com.boutiqueEnLigne.fngcine.service.OrderService;
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
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailService orderDetailService;

    // -------------------------------- ORDER DETAIL-------------------------------------- //

                    // ------------ Access to identified User ------------ //

    @PostMapping("/order-detail")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail, AuthentificationValidation authentificationValidation) {
        if (authentificationValidation.getTokenUserId() == orderDetail.getUserId()) {
            OrderDetail newOrderDetail = orderDetailService.createOrderDetail(orderDetail);
            return new ResponseEntity<>(newOrderDetail, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
                    // ------------ Access to Admin and identified User ------------ //

    @GetMapping("/order-detail/{orderDetailId}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("orderDetailId") Long orderDetailId, AuthentificationValidation authentificationValidation) {
        OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
        if (authentificationValidation.getTokenUserId() == orderDetail.getUserId() || authentificationValidation.isAdmin()) {
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // -------------------------------- ORDER -------------------------------------- //

            // ------------ Access to identified User only ------------ //

    @PostMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, AuthentificationValidation authentificationValidation) {
        if (authentificationValidation.getTokenUserId() == order.getUserId()) {
            Order newOrder = orderService.createOrder(order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        }  else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable("userId") Long userId, AuthentificationValidation authentificationValidation) {
        List<Order> orderListByUser = orderService.getOrdersByUser(userId);
        if (authentificationValidation.getTokenUserId() == userId) {
            return new ResponseEntity<>(orderListByUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

            // ------------ Access to Admin only ------------ //

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orderList = orderService.getOrders();
        return ResponseEntity.ok(orderList);
    }

}
