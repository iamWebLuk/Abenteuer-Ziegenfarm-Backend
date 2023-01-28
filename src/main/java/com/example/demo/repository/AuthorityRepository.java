package com.example.demo.repository;

import com.example.demo.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findById(Long id);
}
