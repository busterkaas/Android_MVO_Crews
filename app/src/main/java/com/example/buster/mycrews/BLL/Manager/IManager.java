package com.example.buster.mycrews.BLL.Manager;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public interface IManager<T> {

    ArrayList<T> getAll() throws Exception;

    T create(T t) throws Exception;

    T update(T t) throws Exception;

    T update(T t, String id) throws Exception;

    boolean delete(T t) throws Exception;

    boolean delete(String id) throws Exception;

}
