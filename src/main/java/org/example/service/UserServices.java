package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServices {

    public static void registerUser(User user) throws SQLException {
        if (checkUser(user)) {
            System.out.println("user already exist ! ");
            return;
        }
        UserRepository.insertUser(user);
    }
    public static boolean checkUser(User user) throws SQLException {
        ResultSet resultSet = UserRepository.checkUser(user);
        return resultSet.next();
    }
    public static boolean loginUser(User user) throws SQLException {
        ResultSet resultSet = UserRepository.loginUser(user);
        return resultSet.next();
    }
}
