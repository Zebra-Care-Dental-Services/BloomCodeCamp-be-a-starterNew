package com.hcc.controllers;

import com.hcc.DTOs.UserRegistrationRequest;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.enums.AuthorityEnum;
import com.hcc.services.UserService;
import com.hcc.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        String role = registrationRequest.getRole();
        AuthorityEnum authorityEnum = AuthorityEnum.fromRole(role);
        if (authorityEnum == null) {
            return ResponseEntity.badRequest().body("Invalid role: " + role);
        }

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        User createdUser = userService.save(user);
        String token = jwtUtil.generateToken(createdUser);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(createdUser);
    }
}
