package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.Tweet;
import com.model.User;

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
    
}
