package com.example.demo.web;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import com.example.demo.service.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAssignment(@AuthenticationPrincipal User user, @RequestBody Assignment assignment, @PathVariable Long id) {
        Assignment newAssignment = assignmentService.update(user, assignment.getGithubUrl(), assignment.getBranch(), assignment.getStatus(), id);
        return ResponseEntity.ok(newAssignment);
    }


    @GetMapping(path = "")
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user) {
        Set<Assignment> userSet = assignmentService.findByUser(user);
        return ResponseEntity.ok().body(userSet);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAssignmentFromID(@AuthenticationPrincipal User user, @PathVariable Long id) {
        Optional<Assignment> userSet = assignmentService.findById(id);
        return ResponseEntity.ok(userSet.orElse(new Assignment()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAssignment(@AuthenticationPrincipal User user, @PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
