package com.example.expensetracker.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from your data source based on the provided username
        // Create a UserDetails object and return it
        // Handle the case when the username is not found
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
