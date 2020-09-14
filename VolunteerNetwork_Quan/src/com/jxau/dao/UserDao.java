package com.jxau.dao;

import com.jxau.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(int id,String username,String password);

    int deleteUser(int id);
}
