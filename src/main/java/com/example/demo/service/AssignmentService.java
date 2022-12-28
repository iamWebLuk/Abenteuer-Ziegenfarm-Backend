package com.example.demo.service;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import com.example.demo.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepo;
    public Assignment save(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("needs to be submitted");
        assignment.setUser(user);

        return assignmentRepo.save(assignment);
    }
}
