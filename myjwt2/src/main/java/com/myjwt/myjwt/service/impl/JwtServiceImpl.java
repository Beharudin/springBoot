package com.myjwt.myjwt.service.impl;

import com.myjwt.myjwt.dto.JwtUserDto;
import com.myjwt.myjwt.exception.JwtUserConflictException;
import com.myjwt.myjwt.exception.JwtUserNotFoundException;
import com.myjwt.myjwt.model.JwtUser;
import com.myjwt.myjwt.repository.JwtRepository;
import com.myjwt.myjwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final JwtRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(JwtUser user) {
        Optional<JwtUser> existingUser = repository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new JwtUserConflictException("User already exist!");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return "User succesfully registered!";
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
    public List<JwtUserDto> getAllUsers() {
        List<JwtUser> users = repository.findAll();
        List<JwtUserDto> userDTOs = new ArrayList<>();

        for (JwtUser user : users) {
            JwtUserDto userDTO = new JwtUserDto();

            userDTO.setUserId(user.getUserId());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
//            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole());

            userDTOs.add(userDTO);
        }
        return userDTOs;
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
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
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
