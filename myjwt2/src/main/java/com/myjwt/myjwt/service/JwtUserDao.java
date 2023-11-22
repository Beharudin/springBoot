package com.myjwt.myjwt.service;

import com.myjwt.myjwt.exception.JwtUserNotFoundException;
import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.repository.JwtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDao {
    private final JwtRepository repository;

    public UserDetails findUserByEmail(String email) {
        Optional<JwtUser> userOptional = repository.findByEmail(email);

        JwtUser jwtUser;
        if (userOptional.isPresent()) {
            jwtUser = userOptional.get();
            return User
                    .withUsername(jwtUser.getEmail())
                    .password(jwtUser.getPassword())
                    .authorities(jwtUser.getAuthorities())
                    .build();
        } else {
            throw new JwtUserNotFoundException("User does not exist!");
        }
    }
}
