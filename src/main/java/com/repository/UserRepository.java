package com.repository;

import com.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public void insertUser(User user);
}
