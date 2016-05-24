package com.example.buster.mycrews.DAL;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public interface IExtendedRepository<T> extends ICRUDRepository<T> {

    /**
     * Reads objects in database and returns them in a list
     *
     * @throws Exception
     */
    public ArrayList<T> readAllUserCrews() throws Exception;


    /**
     * load all objects
     *
     * @throws Exception
     */
    public void loadAllUserCrews(String userId) throws Exception;

}
