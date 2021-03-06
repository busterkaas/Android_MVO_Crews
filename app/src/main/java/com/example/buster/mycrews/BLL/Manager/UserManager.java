package com.example.buster.mycrews.BLL.Manager;

import android.util.Log;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.DAL.http.UserRepository;
import com.example.buster.mycrews.DAL.DALFacade;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class UserManager implements IManager<User> {

    private static UserManager instance = null;
    private DALFacade facade;

    private UserManager() {
        facade = facade.getInstance();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    @Override
    public ArrayList<User> getAll() throws Exception {
        return facade.getUserRepository().readAll();
    }

    @Override
    public void loadAll(String userId) throws Exception {
        facade.getUserRepository().loadAll(userId);
    }

    @Override
    public User create(User user) throws Exception {
        return null;
    }

    @Override
    public void update(User user) throws Exception {
        JSONObject jsonUser = converToJSON(user);
        facade.getUserRepository().update(jsonUser, user.getId());
    }

    @Override
    public User getUpdated() throws Exception {
        return facade.getUserRepository().getUpdated();
    }

    @Override
    public JSONObject converToJSON(User user) throws Exception {
        JSONObject userToUpdate = new JSONObject();

            userToUpdate.put("name", user.getUserName());
            userToUpdate.put("firstName", user.getFirstName());
            userToUpdate.put("lastName", user.getLastName());
            userToUpdate.put("phoneNumber", user.getPhoneNumber());

            return userToUpdate;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

}
