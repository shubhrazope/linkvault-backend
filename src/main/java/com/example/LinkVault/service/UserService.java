package com.example.LinkVault.service;

import com.example.LinkVault.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByID(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    User loginUser(String username, String password);

}
