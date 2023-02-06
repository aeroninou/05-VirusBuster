package com.virusbuster.model;

import com.virusbuster.view.View;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Player {

    //const for all string literals
    private static final String ENTER_YOUR_USERNAME_MESSAGE = "\nEnter your username?: ";
    private static final String REGEX_FOR_USERNAME = "[A-Za-z]{2,10}";
    private static final String ERROR_MESSAGE_FOR_USERNAME = "Error..not valid must be all letters & between 2 and 10 characters.\n";
    private String name;
    private String currentLocation;
    private static final View view = new View();
    private List<String> bag = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String printCurrentBag() {
        StringBuilder result = new StringBuilder();
        if (bag == null || bag.size() == 0){
             result.append("");
        } else {
            for (String item : bag){
                result.append(item);
                if (bag.size() > 1) {
                    result.append(",");
                }
            }
        }
        return result.toString();
        }

    public List<String> getBag() {
        return bag;
    }

    public void setBag(List<String> bag) {
        this.bag = bag;
    }

    public void addToBag(String item) {
        bag.add(item);
    }

    public void dropFromBag(String item) {
        bag.remove(item);
    }

    public String promptForName(){
        return view.prompt(ENTER_YOUR_USERNAME_MESSAGE, REGEX_FOR_USERNAME, ERROR_MESSAGE_FOR_USERNAME);
    }
}