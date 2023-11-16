package com.database.restDatabase.service;

import com.database.restDatabase.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public String addUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(Integer id);
    public String updateUserById(Integer id);
    public String deleteUserById(Integer id);
}
