package com.freixst.securedjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freixst.securedjwt.entity.User;
import com.freixst.securedjwt.repository.UserRepository;
import com.freixst.securedjwt.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired 
    private AuthenticationManager authenticationManager;

    @Autowired 
    private JwtUtil jwtUtil;

    @Autowired 
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        return jwtUtil.generateToken(user.getUsername());
    }
    
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }
}
