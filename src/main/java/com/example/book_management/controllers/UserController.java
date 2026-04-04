package com.example.book_management.controllers;

import com.example.book_management.dtos.LoginDTO;
import com.example.book_management.dtos.RegistrationDTO;
import com.example.book_management.dtos.UserDTO;
import com.example.book_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody RegistrationDTO registrationForm){
        return userService.register(registrationForm.getEmail(), registrationForm.getPassword());
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody @Valid LoginDTO loginForm){
        return userService.login(loginForm.getEmail(), loginForm.getPassword());
    }

}
