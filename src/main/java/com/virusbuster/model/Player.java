package com.virusbuster.model;

import java.util.Locale;

import static com.virusbuster.view.View.prompt;

public class Player {

    private String name;
    private GameMap.LocationLayout currentLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameMap.LocationLayout getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(GameMap.LocationLayout currentLocation) {
        this.currentLocation = currentLocation;
    }

    public static String promptForName(){
        return prompt("\nEnter your username?: ", "[A-Za-z]{2,10}", "Error..not valid must be all letters & between 2 and 10 characters.\n").toUpperCase();
    }
}