package com.example.demo.repository;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Set<Assignment> findByUser(User user);
}
