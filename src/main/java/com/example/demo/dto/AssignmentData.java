package com.example.demo.dto;

import com.example.demo.constants.AssignmentStatus;
import com.example.demo.entities.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AssignmentData {
        private Long id;
        private String assignmentName;
        private AssignmentStatus status;
        private String githubUrl;
        private String branch;
        private String codeReviewVideoUrl;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public AssignmentStatus getStatus() {
            return status;
        }

        public void setStatus(AssignmentStatus status) {
            this.status = status;
        }

        public String getGithubUrl() {
            return githubUrl;
        }

        public void setGithubUrl(String githubUrl) {
            this.githubUrl = githubUrl;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getCodeReviewVideoUrl() {
            return codeReviewVideoUrl;
        }

        public void setCodeReviewVideoUrl(String codeReviewVideoUrl) {
            this.codeReviewVideoUrl = codeReviewVideoUrl;
        }
}
