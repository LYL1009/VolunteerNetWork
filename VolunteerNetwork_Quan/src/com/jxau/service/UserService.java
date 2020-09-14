package com.jxau.service;

import com.jxau.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(int id);

    int addUser(User user);

    int editUser(int id,String username,String password);

    int removeUser(int id);
}
