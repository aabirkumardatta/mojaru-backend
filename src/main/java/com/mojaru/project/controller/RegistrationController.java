package com.mojaru.project.controller;

import com.mojaru.project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistrationController {
    @PostMapping(value = "/v1/api/user/req/signup")
    public ResponseEntity<User> createUser(@RequestBody User user){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Account creation successful.");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
