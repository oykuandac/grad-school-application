package com.gradschool.service;

import java.util.List;

import com.gradschool.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<User> getAll();

	void updatePassword(User user); 
}
