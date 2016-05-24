package com.example.buster.mycrews.BLL.Manager;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.DAL.DAL.http.CrewRepository;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewManager implements IManager<Crew> {

    private CrewManager instance = null;
    CrewRepository crewRepository;

    private CrewManager() {
        crewRepository = new CrewRepository();
    }

    public CrewManager getInstance() {
        if (instance == null) {
            instance = new CrewManager();
        }
        return instance;
    }


    @Override
    public ArrayList<Crew> getAll() throws Exception {
        return null;
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
}
