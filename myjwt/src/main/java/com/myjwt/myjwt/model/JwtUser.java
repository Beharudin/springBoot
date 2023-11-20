package com.myjwt.myjwt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_JWT")
public class JwtUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    private  String username;
    private  String email;
    private String password;
}
