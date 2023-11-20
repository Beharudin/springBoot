package com.myjwt.myjwt.service.impl;

import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.repository.JwtRepository;
import com.myjwt.myjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    JwtRepository repository;
    public JwtServiceImpl(JwtRepository repository) {
        this.repository = repository;
    }

    @Override
    public String register(JwtUser user) {
        repository.save(user);
        return "User added succesfully";
    }

    @Override
    public String login(JwtUser user) {
        return "User logged in succesfully";
    }

    @Override
    public UserDetails getUserByUsername(String email) {
        return null;
    }

}
