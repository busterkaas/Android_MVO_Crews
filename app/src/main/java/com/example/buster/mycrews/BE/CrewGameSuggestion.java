package com.example.buster.mycrews.BE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Buster on 10-05-2016.
 */
public class CrewGameSuggestion implements Serializable {

    int crewDiscount;
    String id, expDateString;
    Date expDate;

    Game game;
    Platform platform;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpDateString() {
        return expDateString;
    }

    public void setExpDateString(String expDateString) {
        this.expDateString = expDateString;
    }

    public CrewGameSuggestion(String id, int crewDiscount, String expDate, Game game, Platform platform) {
        this.id = id;
        this.crewDiscount = crewDiscount;
        this.expDateString = expDate;
        this.game = game;
        this.platform = platform;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public double getCrewDiscount() {
        return crewDiscount;
    }

    public void setCrewDiscount(int crewDiscount) {
        this.crewDiscount = crewDiscount;
    }


}
