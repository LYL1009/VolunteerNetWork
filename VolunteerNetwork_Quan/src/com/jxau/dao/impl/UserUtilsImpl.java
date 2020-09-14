package com.jxau.dao.impl;

import com.jxau.dao.BaseUtils;
import com.jxau.dao.UserDao;
import com.jxau.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtilsImpl extends BaseUtils implements UserDao {
    private Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UserUtilsImpl() {
        connection = BaseUtils.getConnection();
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date date = rs.getDate("registerDate");
                String gender = rs.getString("gender");
                String profile = rs.getString("profile");
                //System.out.println(id+" "+username+" "+password+" "+email+" "+birthday+" "+gender+" "+profile+" ");
                users.add(new User(id,username,password,email,date,gender,profile));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //BaseUtils.release(connection,pst,rs);
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        String sql = "SELECT * FROM users where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                user.setId(id);
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("registerDate"));
                user.setGender(rs.getString("gender"));
                user.setProfile(rs.getString("profile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //BaseUtils.release(connection,pst,rs);
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = 0;
        String sql = "INSERT INTO users(users.username,users.`password`,users.email,users.registerDate,users.gender,users.`profile`) VALUES (?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setDate(4, new Date(new java.util.Date().getTime()));
            pst.setString(5, user.getGender());
            pst.setString(6, user.getProfile());
            i = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //BaseUtils.release(connection,pst,rs);
        return i;
    }

    @Override
    public int updateUser(int id,String username,String password) {
        int i = 0;
        String sql = "UPDATE users SET users.username=?,users.`password`=? WHERE id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setInt(3, id);
            i = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //BaseUtils.release(connection,pst,rs);
        return i;
    }

    @Override
    public int deleteUser(int id) {
        int i = 0;
        String sql = "DELETE FROM users WHERE id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            i = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //BaseUtils.release(connection,pst,rs);
        return i;
    }
}
