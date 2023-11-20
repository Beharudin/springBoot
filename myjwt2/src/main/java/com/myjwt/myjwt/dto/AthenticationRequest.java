package com.myjwt.myjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AthenticationRequest {
    private  String email;
    private  String password;
}
