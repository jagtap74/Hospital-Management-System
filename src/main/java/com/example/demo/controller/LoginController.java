package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User loggedUser = userService.login(
                user.getUsername(),
                user.getPassword());

        if (loggedUser != null) {
            return ResponseEntity.ok("SUCCESS");
        } else {
            return ResponseEntity.status(401).body("INVALID");
        }
    }
}