package com.example.buster.mycrews.BE;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class Game implements Serializable {

    private String id, title, info, coverUrl, trailerUrl;
    private ArrayList<String> gameGenres;

    public Game(String title, String info, String coverUrl) {
        this.title = title;
        this.info = info;
        this.coverUrl = coverUrl;
    }

    public Game(String id, String title, String info, String coverUrl, String trailerUrl, ArrayList<String> gameGenres) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.coverUrl = coverUrl;
        this.trailerUrl = trailerUrl;
        this.gameGenres = gameGenres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        this.trailerUrl = trailerUrl;
    }

    public ArrayList<String> getGameGenres() {
        return gameGenres;
    }

    public void setGameGenres(ArrayList<String> gameGenres) {
        this.gameGenres = gameGenres;
    }
}
