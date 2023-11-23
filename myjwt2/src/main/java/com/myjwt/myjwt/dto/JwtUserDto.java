package com.myjwt.myjwt.dto;

import com.myjwt.myjwt.role.Role;
import lombok.Data;

@Data
public class JwtUserDto {
    private  int userId;
    private  String fullName;
    private  String email;
//    private String password;
    private Role role;
//    private List<GrantedAuthority> authorities;
}
