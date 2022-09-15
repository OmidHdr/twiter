package org.example.repository;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    public static void startDatabase() {
        try (Connection connect = Database.getConnection()) {
            try (Statement statement = connect.createStatement()) {
                statement.addBatch("create table if not EXISTS users(userId serial unique primary key , name varchar(20), password varchar(30) , email varchar(30));");
                statement.addBatch("create table if not exists tweet(tweetId serial unique primary key , message varchar(50), userId int , CONSTRAINT fk_user FOREIGN KEY(userId) REFERENCES users(userId));");
                statement.executeBatch();
                System.out.println("table created .! ");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
