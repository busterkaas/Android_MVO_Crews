package com.example.buster.mycrews.DAL;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public interface ICRUDRepository<T> {

    /**
     * Creates object extending IEntity to database
     */
    public T create(T t) throws Exception;

    /**
     * Reads objects in database and returns them in a list
     */
    public ArrayList<T> readAll() throws Exception;

    /**
     * reads a specific object by id
     */
    public T read(int id) throws Exception;

    /**
     * Update object in database by intputobject
     */
    public void update(T t) throws Exception;

    /**
     * deletes object in database by id
     */
    public void delete(int id) throws Exception;


}
