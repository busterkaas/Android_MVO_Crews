package com.example.buster.mycrews.BLL.GenerelLogic;

/**
 * Created by Buster on 26-05-2016.
 */
public class UserLogic {

    public boolean validateUserInput(String username, String password) {
        if (username.equals("") || password.trim().equals("")) {
            return false;
        }
        return true;
    }
}
