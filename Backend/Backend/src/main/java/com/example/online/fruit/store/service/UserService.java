package com.example.online.fruit.store.service;

import org.springframework.stereotype.Service;
import com.example.online.fruit.store.Repository.UserRepository;
import com.example.online.fruit.store.Entity.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. Register Method (Ab ye null return nahi karega)
    public User register(User user) {
        return userRepository.save(user); 
    }

    // 2. Login Method
    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()) {
            throw new RuntimeException("Email not found!");
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }

        return user; 
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setAddress(updatedUser.getAddress()); // Address bhi update karein
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}