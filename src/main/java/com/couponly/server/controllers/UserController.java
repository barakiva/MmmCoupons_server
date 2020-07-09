package com.couponly.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @PostConstruct
    public void post() {
        System.out.println("User controller");
    }
    @GetMapping("/test")
    public String test() {
        return "User controller";
    }
}
