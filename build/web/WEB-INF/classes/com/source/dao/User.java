/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.dao;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class User implements Serializable {

    private String name;
    private String email;
    private String type;
    private int numCoins;
    private int numPostedStudies;
    private int numPartipation;

    public User() {
    }

    public User(String name, String email, String type, int numCoins, int numPostedStudies, int numPartipation) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numCoins = numCoins;
        this.numPostedStudies = numPostedStudies;
        this.numPartipation = numPartipation;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public int getNumCoins() {
        return numCoins;
    }

    public int getNumPostedStudies() {
        return numPostedStudies;
    }

    public int getNumPartipation() {
        return numPartipation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumCoins(int numCoins) {
        this.numCoins = numCoins;
    }

    public void setNumPostedStudies(int numPostedStudies) {
        this.numPostedStudies = numPostedStudies;
    }

    public void setNumPartipation(int numPartipation) {
        this.numPartipation = numPartipation;
    }

}
