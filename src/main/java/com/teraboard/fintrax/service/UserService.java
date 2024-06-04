package com.teraboard.fintrax.service;

import com.teraboard.fintrax.model.User;
import com.teraboard.fintrax.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {  // Register user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findUserByEmail(String email) { // Find user by email
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) { // Find user by username
        return userRepository.findByUsername(username);
    }


}
