package com.myjwt.myjwt.controllers;

import com.myjwt.myjwt.dto.LoginRequest;
import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.response.ResponseHandler;
import com.myjwt.myjwt.service.impl.JwtServiceImpl;
import com.myjwt.myjwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final UserDetails user = jwtService.findUserByEmail(request.getEmail());

        if (user != null) {
        final String name=jwtService.getUserByEmail(request.getEmail()).getFullName();
//            return ResponseEntity.ok(jwtUtil.generateToken(user));
            return ResponseHandler.responseBuilder("Success", HttpStatus.OK,
                    Map.of("name", name, "token", jwtUtil.generateToken(user)));
        }
        return ResponseEntity.status(400).body("Something went wrong!");
    }

}
