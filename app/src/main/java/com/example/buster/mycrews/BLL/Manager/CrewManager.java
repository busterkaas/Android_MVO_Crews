package com.example.buster.mycrews.BLL.Manager;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.DAL.DAL.http.CrewRepository;
import com.example.buster.mycrews.DAL.DALFacade;
import com.example.buster.mycrews.DAL.IExtendedRepository;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewManager implements IExtendedCrewManager<Crew> {

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
    public void loadAll() throws Exception {
        facade.getCrewRepository().loadAll();
    }

    @Override
    public Crew create(Crew crew) throws Exception {
        return null;
    }

    @Override
    public Crew update(Crew crew) throws Exception {
        return null;
    }

    @Override
    public Crew update(Crew crew, String id) throws Exception {
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

    @Override
    public ArrayList<Crew> readAllUserCrews() throws Exception {
        return facade.getCrewRepository().readAllUserCrews();
    }

    @Override
    public void loadAllUserCrews(String userId) throws Exception {
        facade.getCrewRepository().loadAllUserCrews(userId);
    }
}
