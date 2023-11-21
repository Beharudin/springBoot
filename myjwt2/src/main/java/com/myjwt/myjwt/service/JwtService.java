package com.myjwt.myjwt.service;

import com.myjwt.myjwt.model.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface JwtService {

    public String register(JwtUser user);
    public UserDetails findUserByEmail(String email);
    public JwtUser getUserByEmail(String email);
    public List<JwtUser> getAllUsers();
    public String updateUserById(Integer id, JwtUser user);
    public String deleteUserById(Integer id);

}
