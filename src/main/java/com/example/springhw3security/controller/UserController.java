package com.example.springhw3security.controller;

import com.example.springhw3security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @GetMapping("/simpleUser")
    public String getSimpleUserGreeting() {
        return "hello from simple user!";
    }
    @GetMapping("/adminUser")
    public String getAdminUserGreeting() {
        return "hello from admin user!";
    }

    @GetMapping("/ownerUser")
    public String getOwnerUserGreeting() {
        return "hello from owner user!";
    }
}
