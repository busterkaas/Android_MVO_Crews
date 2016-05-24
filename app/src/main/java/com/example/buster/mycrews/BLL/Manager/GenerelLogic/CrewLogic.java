package com.example.buster.mycrews.BLL.Manager.GenerelLogic;

import android.util.Log;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewLogic {

    public CrewLogic(){

    }

    public boolean isCrewMember(Crew crew, String id) {

        Log.d("logic", " me " + id);

        for (User u : crew.getCrewMembers()) {
            Log.d("logic", " user "+ u.getId());
            if (id == u.getId()) {
                return true;
            }
        }
        return false;
    }
}
