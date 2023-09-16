package com.example.expensetracker.service;

import com.example.expensetracker.model.User;
import org.springframework.context.annotation.Bean;


public interface UserService {
    User registerUser(User user);
}
