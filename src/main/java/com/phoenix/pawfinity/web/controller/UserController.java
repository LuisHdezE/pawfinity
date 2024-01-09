package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.User;
import com.phoenix.pawfinity.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable("userId") int userId) {
        return service.getUser(userId);
    }

    @PostMapping("/save")
    public User save(User user) {
        return service.save(user);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable("userId") int userId) {
        return service.delete(userId);
    }
}
