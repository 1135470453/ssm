package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void insertUser(User user);
}
