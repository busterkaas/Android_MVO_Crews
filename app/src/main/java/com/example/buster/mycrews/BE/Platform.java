package com.example.buster.mycrews.BE;

import java.io.Serializable;

/**
 * Created by Buster on 24-05-2016.
 */
public class Platform implements Serializable {

    String name;
    int price;

    public Platform(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
