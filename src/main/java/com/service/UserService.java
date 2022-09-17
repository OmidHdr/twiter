package com.service;

import java.sql.SQLException;

import com.model.User;

import repository.UserRepository;

public class UserService {


    public static int addUser(User user) throws SQLException{
        if(UserRepository.addUser(user)){
            UserRepository.addUser(user);
            return user.getId();
        }return 0;
    }

    public static boolean signinUser(User user){
        if(UserRepository.signinUser(user)){
            return true;   
        }return false;
    }

    public static int searchById(User user){
        return UserRepository.searchById(user);

    }
    
}
