package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    PasswordEncoder passwordEncoder = encoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        return user.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }

    public User createUser(String username, String password, LocalDate cohortStartDate) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        if (cohortStartDate == null) {
            user.setCohortStartDate(LocalDate.now());
        } else {
            user.setCohortStartDate(cohortStartDate);
        }
        userRepository.save(user);

        return user;
    }

}
