package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Order;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.SpringServletContainerInitializer;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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
        Optional<User> userOptional = userRepository.findById(userId);
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
           userRepository.delete(user);
        }
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
