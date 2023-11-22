package com.myjwt.myjwt.service;

import com.myjwt.myjwt.dto.JwtUserDto;
import com.myjwt.myjwt.model.JwtUser;

import java.util.List;

public interface JwtService {

    public String register(JwtUser user);
    public JwtUser getUserByEmail(String email);
    public List<JwtUserDto> getAllUsers();
    public String updateUserById(Integer id, JwtUser user);
    public String deleteUserById(Integer id);

}
