package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.business.entities.User;
import com.business.repositories.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    @Cacheable(value = "users")
    public List<User> getAllUser() {
        return (List<User>) this.userRepository.findAll();
    }

    // Get Single User
    @Cacheable(value = "user", key = "#id")
    public User getUser(int id) {
        Optional<User> optional = this.userRepository.findById(id);
        return optional.orElse(null);
    }

    // Update User
    @CachePut(value = "user", key = "#id")
    @CacheEvict(value = "users", allEntries = true)
    public void updateUser(User user, int id) {
        user.setUserId(id);
        this.userRepository.save(user);
    }

    // Delete single User
    @CacheEvict(value = { "user", "users" }, allEntries = true)
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    // Add User
    @CacheEvict(value = "users", allEntries = true)
    public void addUser(User user) {
        this.userRepository.save(user);
    }
}

