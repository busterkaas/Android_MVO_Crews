package com.example.buster.mycrews.BE;

import android.location.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Buster on 10-05-2016.
 */
public class User implements Serializable {

    private String userName, firstName, lastName, id;
    private int phoneNumber;
    private Date birthDate;
    private ArrayList<Address> addresses;

    public User(String id, String userName, String firstName, String lastName, int phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public User(String userId, String name){
        this.id = userId;
        this.userName = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    //Private inner class for address
    private class address{
        private String city, streetName, houseNumber;
        private int zipCode;

        public address(String city, String streetName, String houseNumber, int zipCode){
            this.city = city;
            this.streetName = streetName;
            this.houseNumber = houseNumber;
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public int getZipCode() {
            return zipCode;
        }

        public void setZipCode(int zipCode) {
            this.zipCode = zipCode;
        }
    }


}


