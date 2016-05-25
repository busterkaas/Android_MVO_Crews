package com.example.buster.mycrews.BLL.Manager;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.DAL.http.UserRepository;
import com.example.buster.mycrews.DAL.DALFacade;

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
    public User update(User user) throws Exception {
        return null;
    }

    @Override
    public User update(User user, String id) throws Exception {
        return null;
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
