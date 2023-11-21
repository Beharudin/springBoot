package com.myjwt.myjwt.model;

import com.myjwt.myjwt.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "User_JWT2")
public class JwtUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    private  String fullName;
    private  String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

    // Get authorities from role
    public Set<GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }
}
