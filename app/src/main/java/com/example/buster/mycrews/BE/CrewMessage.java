package com.example.buster.mycrews.BE;

/**
 * Created by Buster on 25-05-2016.
 */
public class CrewMessage {
    User user;
    String message;

    public CrewMessage(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
