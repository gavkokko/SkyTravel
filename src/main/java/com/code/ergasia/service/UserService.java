package com.code.ergasia.service;

import com.code.ergasia.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
