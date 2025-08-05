package com.example.LinkVault.controller;

import com.example.LinkVault.model.User;
import com.example.LinkVault.service.UserService;
import com.example.LinkVault.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saved = userService.createUser(user);
        return ResponseEntity.ok(saved);
    }

    //Read user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) {
        User user = userService.getUserByID(id);
        return ResponseEntity.ok(user);
    }

    //Update User
    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id, @RequestBody User updatedUser) {
        User updated = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(updated);
    }

    //Delete user
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return ("User with ID - " + id + " deleted successfully");
    }

    //Login User
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(user);
    }


}
