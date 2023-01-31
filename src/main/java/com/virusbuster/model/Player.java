package com.virusbuster.model;

import com.virusbuster.view.View;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private String name;
    private GameMap.LocationLayout currentLocation;
    private static View view = new View();
    private List<GameItems.ItemInformation> bag = new ArrayList<GameItems.ItemInformation>();

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

    public List<GameItems.ItemInformation> getBag() {
        return bag;
    }
    public String stringOfCurrentBagItems(){
        StringBuilder result = new StringBuilder();
        for (GameItems.ItemInformation item : getBag()) {
            result.append(item.getName());
            if (bag.size() > 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public void addToBag(GameItems.ItemInformation item) {
        bag.add(item);
    }

    public String promptForName(){
        return view.prompt("\nEnter your username?: ", "[A-Za-z]{2,10}", "Error..not valid must be all letters & between 2 and 10 characters.\n");
    }
}