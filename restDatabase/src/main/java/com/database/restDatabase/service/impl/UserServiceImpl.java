package com.database.restDatabase.service.impl;

import com.database.restDatabase.model.User;
import com.database.restDatabase.repository.UserRepository;
import com.database.restDatabase.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User Added";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public String updateUserById(Integer id) {
        return null;
    }

    @Override
    public String deleteUserById(Integer id) {
        return null;
    }
}
