package com.mojaru.project.controller;

import com.mojaru.project.model.User;
import com.mojaru.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("registration")
    public ResponseEntity<User> registration(@RequestBody User userFromRequest) {
        User registeredUser = userService.registerUser(userFromRequest);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/req/login")
    public String login(){
        return "login";
    }

    @GetMapping("/req/signup")
    public String signup(){
        return "signup";
    }

    /*
    @GetMapping("test")
    public ResponseEntity<String> test(@RequestParam Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
    */
}
