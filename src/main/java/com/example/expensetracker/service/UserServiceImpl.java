package com.example.expensetracker.service;

import com.example.expensetracker.model.User;
import com.example.expensetracker.model.UserRepository;
import com.example.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        // Check if the username is already taken (you can add more validation)
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }

        // Encode the user's password before saving it
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        return userRepository.save(user);
    }
}
