package com.jxau.service.impl;

import com.lyl.dao.UserDao;
import com.lyl.dao.Impl.UserDaoImpl;
import com.lyl.entity.User;
import com.lyl.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public List<User> findAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int editUser(int id, String username, String password) {
        return userDao.updateUser(id,username,password);
    }

    @Override
    public int removeUser(int id) {
        return userDao.deleteUser(id);
    }
}
