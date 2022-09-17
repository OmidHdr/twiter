package repository;

import java.sql.Statement;
import java.sql.Connection;

public class Config {
    public static void createTable(){
        final String queryBuildTableUser = "CREATE TABLE if not exists users(user_id serial UNIQUE PRIMARY KEY ,name VARCHAR(15),last_name VARCHAR (20),email VARCHAR (30) UNIQUE,password VARCHAR (50));";
        final String queryBuildTableTweet = "CREATE TABLE if not exists tweets ( tweet_id SERIAL UNIQUE NOT NULL PRIMARY KEY, tweet varchar(100), user_id INT, CONSTRAINT fk_id  FOREIGN KEY (user_id) REFERENCES users(user_id) );";
        try {
            Connection connection = Database.getConnection();
            if(connection != null){
                Statement st = connection.createStatement();
                st.addBatch(queryBuildTableUser);
                st.addBatch(queryBuildTableTweet);
                st.executeBatch();
                st.close();
                System.out.println("Table created ... ");   
            }
        } catch (Exception e) {
            System.out.println("Can't create tables");
        }
    }
    
}
