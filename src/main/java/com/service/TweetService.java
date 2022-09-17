package com.service;

import com.model.Tweet;
import com.model.User;

import repository.TweetRepository;

public class TweetService {
    public static void insertTweet(Tweet tweet){
        TweetRepository.insertTweet(tweet);
    }
}
