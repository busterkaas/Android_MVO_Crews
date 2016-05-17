package com.example.buster.mycrews.Controller;

import com.example.buster.mycrews.BE.User;

/**
 * Created by Buster on 17-05-2016.
 */
public class UserController {

    private static UserController uController;

    private User user;


    private UserController(){
       user = null;
    }

    public static UserController getInstance(){
        if(uController==null){
            uController = new UserController();
        }
        return uController;
    }

    public User getCurrentUser(){
        return user;
    }

    public void userLogin(User user){
        this.user = user;
    }

    public void userLogout(){
        user = null;
    }

}
