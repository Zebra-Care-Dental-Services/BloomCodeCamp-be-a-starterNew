package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

//    private final AssignmentRepository assignmentRepository;

//    public AssignmentService(AssignmentRepository assignmentRepository) {
//        this.assignmentRepository = assignmentRepository;
//    }

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Set<Assignment> findByUser(User user) {
        return assignmentRepository.findByUser(user);
    }
    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }
    public ResponseEntity<?> delete(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
        return ResponseEntity.ok().build();
    }
}
