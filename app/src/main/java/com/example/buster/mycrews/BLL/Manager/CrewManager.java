package com.example.buster.mycrews.BLL.Manager;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.DAL.DALFacade;
import com.example.buster.mycrews.DAL.ICRUDRepository;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewManager implements IManager<Crew> {

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
    public ArrayList<Crew> getAll() throws Exception {
        return facade.getCrewRepository().readAll();
    }

    @Override
    public void loadAll(String userId) throws Exception {
        facade.getCrewRepository().loadAll(userId);
    }

    @Override
    public Crew create(Crew crew) throws Exception {
        return null;
    }


    public void update(Crew crew) throws Exception {

    }

    @Override
    public Crew getUpdated() throws Exception {
        return null;
    }

    @Override
    public JSONObject converToJSON(Crew crew) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Crew crew) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }



}
