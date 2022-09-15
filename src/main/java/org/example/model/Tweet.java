package org.example.model;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class Tweet {
    private Integer id;
    private String message;
    private User user ;

    public Tweet(String message, User user) {
        this.message = message;
        this.user = user;
    }
    public Tweet(int id, String message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }
}
