package com.example.LinkVault.service;

import com.example.LinkVault.model.User;
import com.example.LinkVault.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        if(userRepo.findByUsername(user.getUsername()) == null)
            return userRepo.save(user);
        throw new RuntimeException("User already exists");
    }

    @Override
    public User getUserByID(Long id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found with ID "+ id);
        }
        return user.get();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());

        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }

}
