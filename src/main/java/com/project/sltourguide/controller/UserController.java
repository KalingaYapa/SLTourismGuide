package com.project.sltourguide.controller;

import com.project.sltourguide.entity.User;
import com.project.sltourguide.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
