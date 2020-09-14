package com.jxau.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Date date; // 注册日期
    private String gender;
    private String profile;

    public User() {
    }

    public User(String name, String password, String email, String gender, String profile) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.profile = profile;
    }

    public User(Integer id, String name, String password, String email, Date date, String gender, String profile) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.date = date;
        this.gender = gender;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
