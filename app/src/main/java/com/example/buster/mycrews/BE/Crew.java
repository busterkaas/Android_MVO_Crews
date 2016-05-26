package com.example.buster.mycrews.BE;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Buster on 29-04-2016.
 */
public class Crew implements Serializable {

    private String crewName, crewImgUrl;
    private User crewLeader;
    private String id;
    private ArrayList<User> crewApplicants;
    private ArrayList<User> crewMembers;
    private ArrayList<CrewGameConfirmation> crewGameConfirmations;
    private ArrayList<CrewGameSuggestion> crewGameSuggestions;
    private ArrayList<CrewMessage> crewMessages;

    public ArrayList<CrewMessage> getCrewMessages() {
        return crewMessages;
    }

    public void setCrewMessages(ArrayList<CrewMessage> crewMessages) {
        this.crewMessages = crewMessages;
    }

    public ArrayList<CrewGameSuggestion> getCrewGameSuggestions() {
        return crewGameSuggestions;
    }

    public void setCrewGameSuggestions(ArrayList<CrewGameSuggestion> crewGameSuggestions) {
        this.crewGameSuggestions = crewGameSuggestions;
    }

    public Crew(String id, String crewName, String crewImgUrl){
        this.id = id;
        this.crewName = crewName;

        this.crewImgUrl = crewImgUrl;
    }
/*
    public Crew(String id, String crewName, String crewImgUrl, User crewLeader, ArrayList<User> crewApplicants, ArrayList<User> crewMembers, ArrayList<CrewGameConfirmation> crewGameConfirmations) {
        this.id = id;
        this.crewName = crewName;
        this.crewImgUrl = crewImgUrl;
        this.crewLeader = crewLeader;
        this.crewApplicants = crewApplicants;
        this.crewMembers = crewMembers;
        this.crewGameConfirmations = crewGameConfirmations;
    }
*/
    public Crew(String id, String crewName, String crewImgUrl, User crewLeader,  ArrayList<User> crewApplicants, ArrayList<User> crewMembers, ArrayList<CrewGameSuggestion> crewGameSuggestions ) {
        this.crewName = crewName;
        this.crewImgUrl = crewImgUrl;
        this.crewLeader = crewLeader;
        this.id = id;
        this.crewApplicants = crewApplicants;
        this.crewMembers = crewMembers;
        this.crewGameSuggestions = crewGameSuggestions;
    }


    public Crew(String id, String crewName, String crewImgUrl, User crewLeader,  ArrayList<User> crewApplicants, ArrayList<User> crewMembers ) {
        this.crewName = crewName;
        this.crewImgUrl = crewImgUrl;
        this.crewLeader = crewLeader;
        this.id = id;
        this.crewApplicants = crewApplicants;
        this.crewMembers = crewMembers;
    }

    public void setCrewGameConfirmations(ArrayList<CrewGameConfirmation> crewGameConfirmations) {
        this.crewGameConfirmations = crewGameConfirmations;
    }
    public ArrayList<CrewGameConfirmation> getCrewGameConfirmations() {
        return crewGameConfirmations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getCrewImgUrl() {
        return crewImgUrl;
    }

    public void setCrewImgUrl(String crewImgUrl) {
        this.crewImgUrl = crewImgUrl;
    }

    public User getCrewLeader() {
        return crewLeader;
    }

    public void setCrewLeader(User crewLeader) {
        this.crewLeader = crewLeader;
    }

    public ArrayList<User> getCrewApplicants() {
        return crewApplicants;
    }

    public void setCrewApplicants(ArrayList<User> crewApplicants) {
        this.crewApplicants = crewApplicants;
    }

    public ArrayList<User> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(ArrayList<User> crewMembers) {
        this.crewMembers = crewMembers;
    }

}
