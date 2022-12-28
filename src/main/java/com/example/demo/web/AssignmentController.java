package com.example.demo.web;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.User;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {


    private AssignmentService assignmentService;

    @PostMapping(path = "")
    public ResponseEntity<?> createAssignments(@AuthenticationPrincipal User user) {
        Assignment newAssignment = assignmentService.save(user);

        return ResponseEntity.ok(newAssignment);
    }

}
