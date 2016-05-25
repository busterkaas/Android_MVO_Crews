package com.example.buster.mycrews.BLL.Manager;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.DAL.DALFacade;
import com.example.buster.mycrews.DAL.ICRUDRepository;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewManager implements ICRUDRepository<Crew> {

    private static CrewManager instance = null;
    DALFacade facade;

    private CrewManager() {
        facade = facade.getInstance();
    }

    public static CrewManager getInstance() {
        if (instance == null) {
            instance = new CrewManager();
        }
        return instance;
    }

    @Override
    public void loadAll(String userId) throws Exception {
        facade.getCrewRepository().loadAll(userId);
    }

    @Override
    public Crew create(Crew crew) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Crew> readAll() throws Exception {
        return facade.getCrewRepository().readAll();
    }

    @Override
    public Crew read(int id) throws Exception {
        return null;
    }


    public Crew update(Crew crew) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }



}
