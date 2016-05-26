package com.example.buster.mycrews.BLL.GenerelLogic;

/**
 * Created by Buster on 26-05-2016.
 */
public class UserLogic {

    public boolean validateUserInput(String username, String password){
        if(username.trim().isEmpty()||password.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
