package com.example.academic_management.user.controller;

import com.example.academic_management.user.domain.dto.UserRequest;
import com.example.academic_management.user.domain.dto.UserResponse;
import com.example.academic_management.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse response = userService.signInUser(request);
        return ResponseEntity.created(URI.create("/users/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
