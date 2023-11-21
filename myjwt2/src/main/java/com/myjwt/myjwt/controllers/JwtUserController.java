package com.myjwt.myjwt.controllers;

import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.response.ResponseHandler;
import com.myjwt.myjwt.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jwtusers")
@AllArgsConstructor
public class JwtUserController {

    @Autowired
    private JwtService jwtService;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers(){
        return  ResponseHandler.responseBuilder("Success", HttpStatus.OK, jwtService.getAllUsers());
    }
    @PostMapping("/signup")
    public String register(@RequestBody JwtUser user){
        return jwtService.register(user);
    }

    @PutMapping("{userId}")
    public String updateUserById(@PathVariable("userId") Integer id, @RequestBody JwtUser jwtUser) {
        return jwtService.updateUserById(id, jwtUser);
    }

    @DeleteMapping("{userId}")
    public String deleteUserById(@PathVariable("userId") Integer id) {
        return  jwtService.deleteUserById(id);
    }

}
