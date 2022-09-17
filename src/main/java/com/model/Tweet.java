package com.model;

public class Tweet {
    private int tweetId;
    private String message;
    private int userId;


    public Tweet() {
    }

    public Tweet(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }


    public int getTweetId() {
        return tweetId;
    }


    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    

    

    
}
