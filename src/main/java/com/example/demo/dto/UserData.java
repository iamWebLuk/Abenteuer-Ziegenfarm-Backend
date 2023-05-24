package com.example.demo.dto;

import com.example.demo.constants.AssignmentStatus;
import com.example.demo.constants.Authorities;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;


@Component
public class UserData {

    private Long id;
    private String username;
//    private Collection<GrantedAuthority> role;

    public UserData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Collection<GrantedAuthority> getRole() {
//        return role;
//    }

//    public void setRole(Collection<GrantedAuthority> role) {
//        this.role = role;
//    }

}
