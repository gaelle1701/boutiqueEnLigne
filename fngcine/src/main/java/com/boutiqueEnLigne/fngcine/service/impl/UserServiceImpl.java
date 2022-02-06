package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.repository.OrderRepository;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.service.OrderService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<User>getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteUserById(Long userId){
        User user = userRepository.getById(userId);
        List<Order> orderList = orderService.getOrdersByUser(userId);
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

}
