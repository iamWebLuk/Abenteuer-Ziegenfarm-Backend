package com.example.demo.service;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import com.example.demo.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepo;
    public Assignment save(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("needs to be submitted");
        user.setPassword("");
        assignment.setUser(user);


        return assignmentRepo.save(assignment);
    }

    public Assignment update(User user, String gitHubURL, String branch, String status) {
        Assignment assignment = new Assignment();
            assignment.setId(user.getId());
            if (gitHubURL != null && branch != null && status != null) {
            assignment.setGithubUrl(gitHubURL);
            assignment.setBranch(branch);
            assignment.setStatus(status);
            user.setPassword("");
            assignment.setUser(user);

            }
            return assignmentRepo.save(assignment);
    }

    public Set<Assignment> findByUser(User user) {
        return assignmentRepo.findByUser(user);
    }

    public Optional<Assignment> findById(Long id) {
        return assignmentRepo.findById(id);
    }


}
