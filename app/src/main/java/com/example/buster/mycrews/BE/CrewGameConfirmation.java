package com.example.buster.mycrews.BE;

import java.io.Serializable;

/**
 * Created by Buster on 10-05-2016.
 */
public class CrewGameConfirmation implements Serializable {

    private User user;
    private CrewGameSuggestion crewGameSuggestion;
    boolean hasConfirmed;

    public CrewGameConfirmation(User user, CrewGameSuggestion crewGameSuggestion, boolean hasConfirmed) {
        this.user = user;
        this.crewGameSuggestion = crewGameSuggestion;
        this.hasConfirmed = hasConfirmed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CrewGameSuggestion getCrewGameSuggestion() {
        return crewGameSuggestion;
    }

    public void setCrewGameSuggestion(CrewGameSuggestion crewGameSuggestion) {
        this.crewGameSuggestion = crewGameSuggestion;
    }

    public boolean isHasConfirmed() {
        return hasConfirmed;
    }

    public void setHasConfirmed(boolean hasConfirmed) {
        this.hasConfirmed = hasConfirmed;
    }
}
