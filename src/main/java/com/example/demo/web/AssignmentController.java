package com.example.demo.web;

import com.example.demo.dto.AssignmentData;
import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import com.example.demo.service.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {


    @Autowired
    private AssignmentService assignmentService;

    @PostMapping(path = "")
    public ResponseEntity<?> createAssignments(@AuthenticationPrincipal User user) {
        Assignment newAssignment = assignmentService.save(user);

        return ResponseEntity.ok(newAssignment);
    }
    @CrossOrigin
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAssignment(@AuthenticationPrincipal User user, @RequestBody Assignment assignment, @PathVariable Long id) {
        Assignment newAssignment = assignmentService.update(user, assignment.getAssignmentName(), assignment.getGithubUrl(), assignment.getBranch(), assignment.getStatus(), id);
        AssignmentData assignmentData = new AssignmentData();
        assignmentData.setId(newAssignment.getId());
        assignmentData.setStatus(assignment.getStatus());
        assignmentData.setGithubUrl(assignment.getGithubUrl());
        assignmentData.setBranch(assignment.getBranch());
        assignmentData.setCodeReviewVideoUrl(assignment.getCodeReviewVideoUrl());
        assignmentData.setAssignmentName(assignment.getAssignmentName());
        return ResponseEntity.ok(assignmentData);
    }

    @CrossOrigin

    @GetMapping(path = "")
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user) {
        Set<Assignment> userSet = assignmentService.findByUser(user);
        Set<AssignmentData> assignmentData = new HashSet<>();
        for (Assignment users: userSet) {
            AssignmentData assignment = new AssignmentData();
            assignment.setId(users.getId());
            assignment.setAssignmentName(users.getAssignmentName());
            assignment.setGithubUrl(users.getGithubUrl());
            assignment.setBranch(users.getBranch());
            assignment.setCodeReviewVideoUrl(users.getCodeReviewVideoUrl());
            assignment.setStatus(users.getStatus());
            assignmentData.add(assignment);
        }
        return ResponseEntity.ok().body(assignmentData);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAssignmentFromID(@AuthenticationPrincipal User user, @PathVariable Long id) {
        Optional<Assignment> userSet = assignmentService.findById(id);
        AssignmentData assignmentData = new AssignmentData();
        if (userSet.isPresent()) {
            assignmentData.setId(userSet.get().getId());
            assignmentData.setStatus(userSet.get().getStatus());
            assignmentData.setGithubUrl(userSet.get().getGithubUrl());
            assignmentData.setBranch(userSet.get().getBranch());
            assignmentData.setCodeReviewVideoUrl(userSet.get().getCodeReviewVideoUrl());
            assignmentData.setAssignmentName(userSet.get().getAssignmentName());
        }
        return ResponseEntity.ok(assignmentData);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAssignment(@AuthenticationPrincipal User user, @PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
