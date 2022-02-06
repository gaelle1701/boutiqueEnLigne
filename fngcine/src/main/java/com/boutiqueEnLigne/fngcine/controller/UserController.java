package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.User;
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
    private UserService userService;

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
            User user = userService.getUserById(id);
            String password = user.getPassword();
            userToUpdate.setPassword(password);
            User updatedUser = userService.updateUser(userToUpdate);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }





}
