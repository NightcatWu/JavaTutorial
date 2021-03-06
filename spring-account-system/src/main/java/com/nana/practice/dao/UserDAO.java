package com.nana.practice.dao;

import com.nana.practice.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> listUsers();

    public User getUser(int userId);

    public String addUser(User theUser);

}
