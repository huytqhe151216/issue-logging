package com.rabiloo.issue_logging.services;

import com.rabiloo.issue_logging.DTO.Auth.RegisterRequest;
import com.rabiloo.issue_logging.domain.User;
import com.rabiloo.issue_logging.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Register new user
     */
    public String register(RegisterRequest registerRequest) {
        // Check if email is already in use
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email đã được sử dụng!");
        }

        // Create new user
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setFullName(registerRequest.getFullName());
        newUser.setAdmin(false);
        newUser.setDeleted(false);

        userRepository.save(newUser);

        return "Register successfully!";
    }
}