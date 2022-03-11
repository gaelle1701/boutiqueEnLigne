package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.mail.EmailService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private EmailService email;

    ResponseEntity responseEntity;

    // -------------------------------- ORDER DETAIL-------------------------------------- //

    // ------------ Access to identified User ------------ //

    @PostMapping("/order-detail")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail, HttpServletRequest request, AuthentificationValidation authentificationValidation) {
        if (authentificationValidation.getTokenUserId() == orderDetail.getUserId()) {
            List<OrderDetail> orderDetailList = (List<OrderDetail>) request.getSession().getAttribute("DETAILS_SESSION");
            if (orderDetailList == null) {
                orderDetailList = new ArrayList<>();
                request.getSession().setAttribute("DETAILS_SESSION", orderDetailList);
            }
            orderDetailService.createOrderDetail(orderDetail);
            orderDetailList.add(orderDetail);
            request.getSession().setAttribute("DETAILS_SESSION", orderDetailList);
            System.out.println("SESSION ---------------------> " + orderDetailList);
            return new ResponseEntity<>(orderDetail, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    // ------------ Access to Admin and identified User ------------ //

    @GetMapping("/order-detail/{orderDetailId}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("orderDetailId") Long orderDetailId, HttpServletRequest request, AuthentificationValidation authentificationValidation) {
        List<OrderDetail> orderDetailList = (List<OrderDetail>) request.getSession().getAttribute("DETAILS_SESSION");
        for (OrderDetail orderDetail: orderDetailList
        ) {
            System.out.println(orderDetail);
        }
        OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
        System.out.println(orderDetail.getUserId());
        if (authentificationValidation.getTokenUserId() == orderDetail.getUserId() || authentificationValidation.isAdmin()) {
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/order-detail-list")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<List<OrderDetail>> getOrderDetailList(HttpServletRequest request, AuthentificationValidation authentificationValidation) {
        List<OrderDetail> orderDetailList = (List<OrderDetail>) request.getSession().getAttribute("DETAILS_SESSION");
        for (OrderDetail orderDetail: orderDetailList) {
            System.out.println(orderDetail);
        }
        return new ResponseEntity<>(orderDetailList, HttpStatus.OK);
    }

    // -------------------------------- ORDER -------------------------------------- //

    // ------------ Access to identified User only ------------ //

    @PostMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, AuthentificationValidation authentificationValidation) {
        Long tokenUserId = authentificationValidation.getTokenUserId();
        User user = userService.getUserById(authentificationValidation.getTokenUserId());
        order.setUser(user);
        Long userIdOrder = order.getUser().getId();
        if (tokenUserId == userIdOrder) {
            orderService.createOrder(order);
            email.sendSimpleMessage(order);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
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