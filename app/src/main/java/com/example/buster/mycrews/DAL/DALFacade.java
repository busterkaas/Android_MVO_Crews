package com.example.buster.mycrews.DAL;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.DAL.http.CrewRepository;
import com.example.buster.mycrews.DAL.DAL.http.UserRepository;

/**
 * Created by Buster on 24-05-2016.
 */
public class DALFacade {

    ICRUDRepository<Crew> crewRepository;
    ICRUDRepository<User> userRepository;

    public ICRUDRepository<Crew> getCrewRepository(){
        if(crewRepository==null){
            crewRepository = new CrewRepository();
        }
        return crewRepository;
    }

    public ICRUDRepository<User> getUserRepository(){
        if(userRepository==null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
}
