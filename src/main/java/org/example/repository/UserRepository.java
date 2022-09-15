package org.example.repository;

import org.example.model.User;

import java.sql.*;

public class UserRepository {

    // section insert user
    public static void insertUser(User user) {
        final String queryInsert = "insert into users values (DEFAULT, ?,?,?);";
        try (Connection connect = Database.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(queryInsert)) {
                statement.setString(1,user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3, user.getPassword());
                statement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //section check user
    public static ResultSet checkUser(User user) {
        final String queryCheck = "select * from users where email ilike ?;";
        try (Connection connect = Database.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(queryCheck)) {
                statement.setString(1,user.getEmail());
                ResultSet resultSet = statement.executeQuery();
                return resultSet;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    //section login
    public static ResultSet loginUser(User user) {
        final String queryLogin = "select * from users where email ilike ? and password = ?;";
        try (Connection connect = Database.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(queryLogin)) {
                statement.setString(1,user.getEmail());
                statement.setString(2,user.getPassword());
                ResultSet resultSet = statement.executeQuery();
                return resultSet;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
