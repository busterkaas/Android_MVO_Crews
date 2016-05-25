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

    private static DALFacade instance;

    private DALFacade(){

    }

    public static DALFacade getInstance(){
        if(instance==null){
            instance = new DALFacade();
        }
        return instance;
    }


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
