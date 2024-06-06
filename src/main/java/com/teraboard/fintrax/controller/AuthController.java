package com.teraboard.fintrax.controller;

import com.teraboard.fintrax.model.User;
import com.teraboard.fintrax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return user+" was registered successfully!";
    }

    @PostMapping
    public String loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getEmail());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return "Login successful!";
        }
        return "Login failed! \n Invalid username or password!";
    }
}