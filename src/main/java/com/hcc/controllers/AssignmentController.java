package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {


    @Autowired
    // AssignmentService  assignmentService

    @Autowired
    // UserService userService

    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long assignmentId, @RequestBody Assignment assignment,
                                              @AuthenticationPrincipal User user) {

        //logic to decide what role the user is....
        // if the user has a role of Reviewer, then maybe attach that user as the code reviewer of this assignment

        Assignment updateAssignemnt = assignmentService.save(assignment);

        return ResponseEntity.ok(updateAssignemnt);
    }

    @GetMapping
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user) {

        Set<Assignment> assignmentsByUser = assignmentService.findByUser(user);

        return ResponseEntity.ok(assignmentsByUser);
    }

    @DeleteMapping("{assignmentId}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long assignmentId, @AuthenticationPrincipal User user) {
        return  assignmentService.delete(assignmentId);
    }

}
