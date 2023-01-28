package com.example.demo.service;

import com.example.demo.entities.Authority;
import com.example.demo.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Optional<Authority> getUserAuthority(Long id) {
        return authorityRepository.findById(id);
    }
}
