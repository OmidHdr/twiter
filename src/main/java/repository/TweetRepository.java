package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Tweet;

public class TweetRepository {
    
    public static boolean insertTweet(Tweet tweet){
        try {
            final String queryAddTweet = "INSERT INTO tweets VALUES(DEFAULT,?,?);";
            Connection connection  = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(queryAddTweet);
            statement.setString(1, tweet.getMessage());
            statement.setInt(2, tweet.getUserId());
            statement.execute();     
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static ResultSet showAllTweets(int id){
        final String showAllTweet = "SELECT tweet FROM tweets where user_id = ?;";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(showAllTweet);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            return result;
        } catch (Exception e) {
            return null;
        }

    }
    
}
