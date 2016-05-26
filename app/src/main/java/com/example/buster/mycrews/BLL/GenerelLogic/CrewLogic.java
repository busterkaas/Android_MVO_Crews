package com.example.buster.mycrews.BLL.GenerelLogic;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;

/**
 * Created by Buster on 24-05-2016.
 */
public class CrewLogic {

    public CrewLogic() {

    }

    public boolean isCrewMember(Crew crew, String id) {

        for (User u : crew.getCrewMembers()) {
            if (id.equals(u.getId())) {
                return true;
            }
        }
        return false;
    }


    public boolean isCrewLeader(Crew crew, String id) {

        if (crew.getCrewLeader().getId().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean hasApplied(Crew crew, String id) {

        for (User u : crew.getCrewApplicants()) {
            if (id.equals(u.getId())) {
                return true;
            }
        }
        return false;
    }
}
