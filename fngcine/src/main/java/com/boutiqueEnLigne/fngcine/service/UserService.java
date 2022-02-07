package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.User;

public interface UserService {
    Iterable<User>getUsers();
    User getUserById(Long id);
    void deleteUserById(Long userId);
    User updateUser(User userToUpdate);
}
