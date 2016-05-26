package com.example.buster.mycrews.DAL;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public interface ICRUDRepository<T> {

    /**
     * Creates object extending IEntity to database
     * @throws Exception
     */
    public T create(T t) throws Exception;

    /**
     * load all objects
     * @throws Exception
     */
    public void loadAll(String id) throws Exception;

    /**
     * Reads objects in database and returns them in a list
     * @throws Exception
     */
    public ArrayList<T> readAll() throws Exception;

    /**
     * reads a specific object by id
     * @throws Exception
     */
    public T read(int id) throws Exception;

    /**
     * Update object in database by intputobject
     * @throws Exception
     */
    public void update(JSONObject t, String id) throws Exception;

    /**
     * Read updated user
     * @return
     */
    public T getUpdated() throws Exception;

    /**
     * deletes object in database by id
     * @throws Exception
     */
    public void delete(int id) throws Exception;



}
