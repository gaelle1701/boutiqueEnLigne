package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
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


    // -------------------------------- ACCESS TO ADMIN AND IDENTIFIED USER -------------------------------------- //

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId, AuthentificationValidation authentificationValidation) {
        User user = userService.getUserById(userId);
        if (authentificationValidation.getTokenUserId() == userId || authentificationValidation.isAdmin()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User userToUpdate, AuthentificationValidation authentificationValidation){
        if (authentificationValidation.getTokenUserId() == userId || authentificationValidation.isAdmin()) {
            User user = userService.getUserById(userId);
            String password = user.getPassword();
            userToUpdate.setPassword(password);
            User updatedUser = userService.updateUser(userToUpdate);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // -------------------------------- ACCESS TO ADMIN ONLY -------------------------------------- //

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Iterable<User>> getUsers(AuthentificationValidation authentificationValidation) {
        if (authentificationValidation.isAdmin()){
            Iterable<User> userList = userService.getUsers();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUserById(@PathVariable("userId") Long id, AuthentificationValidation authentificationValidation) {
        if (authentificationValidation.isAdmin()){
            User user = userService.getUserById(id);
            userService.deleteUserById(id);
        } else {
            ResponseEntity.status(HttpStatus.FORBIDDEN);
        }
    }

}
