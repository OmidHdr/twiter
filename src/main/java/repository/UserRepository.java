package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserRepository {

    final static String queryAddUser = "INSERT INTO users VALUES(DEFAULT,?,?,?,?);";
    final static String querySignin = "select * FROM users WHERE email = ? AND password = ?";

    public static boolean addUser(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(queryAddUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            return statement.execute();
        } catch (Exception e) {
            return false;
        }
    }

    // section sign in
    public static boolean signinUser(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySignin);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static int searchById(User user){
        final String querySearchById = "select user_id from users where email ilike ?;";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(querySearchById);
            statement.setString(1,user.getEmail());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return result.getInt("user_id");
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
        
    }

}
