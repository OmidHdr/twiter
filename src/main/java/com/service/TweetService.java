package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Tweet;
import com.model.User;

import repository.TweetRepository;

public class TweetService {
    public static void insertTweet(Tweet tweet){
        TweetRepository.insertTweet(tweet);
    }
    public static ResultSet showAllTweets(int id) throws SQLException{
        if (TweetRepository.showAllTweets(id).next())
            return TweetRepository.showAllTweets(id);
        return null;
        
    }
}
