package com.example.demo.filter;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTFilter {

    @Autowired
    private UserRepository userRepository;





}
