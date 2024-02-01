package com.barbershop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.domain.user.User;
import com.barbershop.domain.user.dto.CreateUserDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserDTO newUser) {
        User user = new User(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
}
