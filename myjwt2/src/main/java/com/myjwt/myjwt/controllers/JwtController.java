package com.myjwt.myjwt.controllers;

import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jwtusers")
@AllArgsConstructor
public class JwtController {

    @Autowired
    private JwtService service;

    @GetMapping
    public String getAll(){
        return "Welcome to my Api";
    }
    @PostMapping("/signup")
    public String register(@RequestBody JwtUser user){
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody JwtUser user){
        return service.login(user);
    }
}
