package com.myjwt.myjwt.service.impl;

import com.myjwt.myjwt.exception.JwtUserConflictException;
import com.myjwt.myjwt.exception.JwtUserNotFoundException;
import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.repository.JwtRepository;
import com.myjwt.myjwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final JwtRepository repository;

    @Override
    public String register(JwtUser user) {
        Optional<JwtUser> existingUser = repository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new JwtUserConflictException("User already exist!");
        } else {
            repository.save(user);
            return "User succesfully registered!";
        }
    }

    @Override
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

    @Override
    public JwtUser getUserByEmail(String email) {

        Optional<JwtUser> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new JwtUserNotFoundException("User does not exist!");
        }
    }

    @Override
    public List<JwtUser> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public String updateUserById(Integer id, JwtUser user) {
        Optional<JwtUser> existingUserOptional = repository.findById(id);
        Optional<JwtUser> existingUser = repository.findByEmail(user.getEmail());

        if (existingUserOptional.isEmpty())
            throw new JwtUserNotFoundException("User does not exist");
        else if (existingUser.isPresent() && id!=existingUser.get().getUserId()) {
            throw new JwtUserConflictException("Email already exist!");
        } else {
            JwtUser newUser = existingUserOptional.get();

            newUser.setEmail(user.getEmail());
            newUser.setFullName(user.getFullName());
            newUser.setPassword(user.getPassword());
            repository.save(newUser);
            return "Updated succesfully";
        }
    }

    @Override
    public String deleteUserById(Integer id) {
        repository.deleteById(id);
        return "Deleted succesfully";
    }

}
