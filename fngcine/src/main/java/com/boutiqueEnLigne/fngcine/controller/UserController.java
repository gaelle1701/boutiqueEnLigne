package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }





}
