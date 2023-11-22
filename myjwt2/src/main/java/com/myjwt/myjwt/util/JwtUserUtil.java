package com.myjwt.myjwt.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
public class JwtUserUtil {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder customPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public String encodePwd(String pwd){
        return passwordEncoder.encode(pwd);
    }

}
