package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import com.boutiqueEnLigne.fngcine.entity.User;
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

import java.util.ArrayList;
import java.util.List;


@RestController
@Getter
@Setter
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    OrderDetailService orderDetailService;

    // -------------------------------- ORDER DETAIL-------------------------------------- //

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

    @GetMapping("/order-details/{userId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<OrderDetail>> getOrderDetailByUser(@PathVariable("userId") Long userId, AuthentificationValidation authentificationValidation) {
        List<OrderDetail> orderDetailListByUser = orderDetailService.getOrderDetailsByUser(userId);
        if (authentificationValidation.getTokenUserId() == userId) {
            return new ResponseEntity<>(orderDetailListByUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/order-detail/{orderDetailId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("orderDetailId") Long orderDetailId, AuthentificationValidation authentificationValidation) {
        OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
        if (authentificationValidation.getTokenUserId() == orderDetail.getUserId()) {
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // -------------------------------- ORDER -------------------------------------- //

    @PostMapping("/orders")
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

    // -------------------------------- USER -------------------------------------- //

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId, AuthentificationValidation authentificationValidation) {
        User user = userService.getUserById(userId);
        if (authentificationValidation.getTokenUserId() == userId) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User userToUpdate, AuthentificationValidation authentificationValidation){
        if (authentificationValidation.getTokenUserId() == userId) {
            Long id = userToUpdate.getId();
            User user = userService.getUserById(userId);
            String password = user.getPassword();
            userToUpdate.setPassword(password);
            User updatedUser = userService.updateUser(userToUpdate);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
