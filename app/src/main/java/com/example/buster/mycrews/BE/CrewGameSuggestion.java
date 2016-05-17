package com.example.buster.mycrews.BE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Buster on 10-05-2016.
 */
public class CrewGameSuggestion implements Serializable {

    private String gameTitle, platformName, gameInfo, coverUrl, trailerUrl;
    private ArrayList<String> gameGenres;
    private double gamePrice, crewDiscount;
    private Date expDate;


    public CrewGameSuggestion(String gameTitle, String platformName, String gameInfo, String coverUrl, String trailerUrl, ArrayList<String> gameGenres, double gamePrice, double crewDiscount, Date expDate) {
        this.gameTitle = gameTitle;
        this.platformName = platformName;
        this.gameInfo = gameInfo;
        this.coverUrl = coverUrl;
        this.trailerUrl = trailerUrl;
        this.gameGenres = gameGenres;
        this.gamePrice = gamePrice;
        this.crewDiscount = crewDiscount;
        this.expDate = expDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public ArrayList<String> getGameGenres() {
        return gameGenres;
    }

    public void setGameGenres(ArrayList<String> gameGenres) {
        this.gameGenres = gameGenres;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public double getCrewDiscount() {
        return crewDiscount;
    }

    public void setCrewDiscount(double crewDiscount) {
        this.crewDiscount = crewDiscount;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(String gameInfo) {
        this.gameInfo = gameInfo;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        trailerUrl = trailerUrl;
    }

}
