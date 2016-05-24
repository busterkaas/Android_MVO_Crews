package com.example.buster.mycrews.DAL;

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
    public void update(T t) throws Exception;

    /**
     * deletes object in database by id
     * @throws Exception
     */
    public void delete(int id) throws Exception;

    /**
     *
     * @throws Exception
     */
    public void loadAll() throws Exception;


}
