package com.couponly.server.controllers;

import com.couponly.server.model.users.Login;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @PostConstruct
    public void post() {
    }
    @GetMapping("/test")
    public String test() {
        return "User controller";
    }

//    @PostMapping("/register-user")
//    public void registerUser(@RequestBody Login user){
//
//    }
//    @GetMapping("/login-user")
    @DeleteMapping("/delete-user")
    public void deleteUser(long userId){

    }
}
