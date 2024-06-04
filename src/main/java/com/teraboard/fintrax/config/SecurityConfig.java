package com.teraboard.fintrax.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig implements SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {
    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Authorize requests
                .antMatchers("/register", "/login").permitAll() // Allow register and login
                .anyRequest().authenticated() // All other requests need to be authenticated
                .and() // And
                .formLogin() // Form login
                .loginPage("/login") // Login page
                .permitAll() // Allow all
                .and() // And
                .logout() // Logout
                .permitAll(); // Allow all
    }


    @Bean
    public PasswordEncoder passwordEncoder() { // Password encoder using BCrypt
        return new BCryptPasswordEncoder();
    }
}


