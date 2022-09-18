package com.example.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.Tweet;
import com.model.User;
import com.service.TweetService;
import com.service.UserService;

import repository.Database;

public class App {

    static Scanner scanner = new Scanner(System.in);
    private static boolean flag = true;
    private static boolean flag2 = true;

    public static void tweet(int id) throws SQLException{
        System.out.println("\n------------------------");
        System.out.println("Press '1' to write a tweet ");
        System.out.println("Press '2' to show all tweets ");
        System.out.println("press '3' to quit ");
        switch(scanner.nextInt()){
            case 1:
                System.out.println("Enter your tweet : ");
                scanner.nextLine();
                String message = scanner.nextLine();
                Tweet tweet = new Tweet();
                tweet.setMessage(message);
                tweet.setUserId(id);
                TweetService.insertTweet(tweet);
                break;
            case 2:
                System.out.println("printing all tweets ... ");
                ResultSet result = TweetService.showAllTweets(id);
                while(result.next()){
                    System.out.println(result.getString("tweet"));
                }
                break;
            case 3:
                flag2 = false;
                break;

        }

    }

    public static void run() throws SQLException{
        System.out.println("\n---------------------------");
        System.out.print("✎. Press '1' to signup \n");
        System.out.print("✎. Press '2' to signin \n");
        System.out.print("✎. Press '3' to quit \n");
        switch(scanner.nextInt()){
            case 1:
                User user = new User();
                System.out.print("Enter your name : ");
                user.setName(scanner.next());
                System.out.print("Enter your lastName : ");
                user.setLastName(scanner.next());
                System.out.println("Enter your Email : ");
                user.setEmail(scanner.next());
                System.out.println("Enter your password : ");
                user.setPassword(scanner.next());
                int result =  UserService.addUser(user);
                if (result >= 1)System.out.println("User created");
                else System.out.println("User already exist");
                break;
            case 2:
                User userSignin = new User();
                System.out.print("Enter your email : ");
                userSignin.setEmail(scanner.next());
                System.out.print("Enter your password : ");
                userSignin.setPassword(scanner.next());
                if (UserService.signinUser(userSignin)) {
                    System.out.println("User login sucessfully ");
                    while(flag2 == true){
                        tweet(UserService.searchById(userSignin));
                    }
                }
                else System.out.println("Wrong Email or password ");
                break;
            case 3:
                flag = false;
                break;
        }
    }
    public static void main( String[] args ) throws SQLException{
        Database.getConnection();
        repository.Config.createTable();
        
        
        while(flag == true){
            run();
        }


    }
}
