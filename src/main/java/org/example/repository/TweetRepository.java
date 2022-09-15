package org.example.repository;
import org.example.model.Tweet;
import org.example.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TweetRepository {

    // section insert tweet
    public static void insertTweet(Tweet tweet , User user) {
        final String queryInsert = "insert into tweet values (DEFAULT ,?,?);";

        try (Connection connect = Database.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(queryInsert)) {
                ResultSet resultSet = UserRepository.checkUser(user);
                if (resultSet.next()){
                    statement.setString(1,tweet.getMessage());
                    statement.setInt(2, resultSet.getInt("userid"));
                    statement.execute();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
