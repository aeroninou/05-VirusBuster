package com.virusbuster.model;

import com.virusbuster.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Player implements Serializable{

    //const for all string literals
    private static final String ENTER_YOUR_USERNAME_MESSAGE = "\nEnter your username?: ";
    private static final String REGEX_FOR_USERNAME = "[A-Za-z]{2,10}";
    private static final String ERROR_MESSAGE_FOR_USERNAME = "Error..not valid must be all letters & between 2 and 10 characters.\n";
    private String name;
    private String currentLocation;
    private static View view = new View();
    private List<GameItem.ItemInformation> bag = new ArrayList<GameItem.ItemInformation>();

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

    public List<GameItem.ItemInformation> getBag() {
        return bag;
    }
    public String stringOfCurrentBagItems(){
        StringBuilder result = new StringBuilder();
        for (GameItem.ItemInformation item : getBag()) {
            result.append(item.getName());
            if (bag.size() > 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public void addToBag(GameItem.ItemInformation item) {
        bag.add(item);
    }

    public void dropFromBag(GameItem.ItemInformation item) {
        bag.remove(item);
    }

    public String promptForName(){
        return view.prompt(ENTER_YOUR_USERNAME_MESSAGE, REGEX_FOR_USERNAME, ERROR_MESSAGE_FOR_USERNAME);
    }
}