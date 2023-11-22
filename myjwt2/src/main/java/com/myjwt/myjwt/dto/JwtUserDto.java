package com.myjwt.myjwt.dto;

import com.myjwt.myjwt.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
public class JwtUserDto {
    private  int userId;
    private  String fullName;
    private  String email;
//    private String password;
    private Role role;
//    private List<GrantedAuthority> authorities;
}
