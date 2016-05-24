package com.example.buster.mycrews.BLL.Manager;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public interface IExtendedCrewManager<T> extends IManager<T> {


    public ArrayList<T> readAllUserCrews() throws Exception;

    public void loadAllUserCrews(String userId) throws Exception;


}
