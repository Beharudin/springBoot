package com.myjwt.myjwt.service;

import com.myjwt.myjwt.model.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JwtService {

    public String register(JwtUser user);
    public String login(JwtUser user);

    public UserDetails getUserByUsername(String email);

}
