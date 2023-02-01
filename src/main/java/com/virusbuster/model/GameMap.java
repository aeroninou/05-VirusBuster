package com.virusbuster.model;


import java.util.HashMap;
import java.util.List;

class GameMap {

    //fields from Json objects
    private Armory armory;
    private Cafeteria cafeteria;
    private Area51 area51;
    private PortalRoom portal;
    private Amazon amazon;
    private Dubai dubai;
    private Uzbekistan uzbekistan;
    private Greenland greenland;
    private Laboratory laboratory;

    //setters and getters to populate the values from JSON
    public Armory getArmory() {
        return armory;
    }

    public void setArmory(Armory armory) {
        this.armory = armory;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public Area51 getArea51() {
        return area51;
    }

    public void setArea51(Area51 area51) {
        this.area51 = area51;
    }

    public PortalRoom getPortal() {
        return portal;
    }

    public void setPortal(PortalRoom portal) {
        this.portal = portal;
    }

    public Amazon getAmazon() {
        return amazon;
    }

    public void setAmazon(Amazon amazon) {
        this.amazon = amazon;
    }

    public Dubai getDubai() {
        return dubai;
    }

    public void setDubai(Dubai dubai) {
        this.dubai = dubai;
    }

    public Uzbekistan getUzbekistan() {
        return uzbekistan;
    }

    public void setUzbekistan(Uzbekistan uzbekistan) {
        this.uzbekistan = uzbekistan;
    }

    public Greenland getGreenland() {
        return greenland;
    }

    public void setGreenland(Greenland greenland) {
        this.greenland = greenland;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    //checks from input request and finds the specific location
    public LocationLayout getLocation(String name) {
        if (name == null) {
            return null;
        }
        switch (name) {
            case "Area51":
                return area51;
            case "Portal Room":
                return portal;
            case "Amazon Jungle Fever, Brazil":
                return amazon;
            case "Burj Khalifa, Dubai":
                return dubai;
            case "Tashkent, Uzbekistan":
                return uzbekistan;
            case "Nuuk, Greenland":
                return greenland;
            case "Laboratory":
                return laboratory;
            case "Cafeteria":
                return cafeteria;
            case "Armory":
                return armory;
            default:
                return null;
        }
    }

    //getter and setters that is being extended to the JSON object class to utilize the getters and setters
    public static class LocationLayout {
        private String name;
        private HashMap<String, String> directions;
        private String description;
        private List<String> item;

        public LocationLayout() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, String> getDirections() {
            return directions;
        }

        public void setDirections(HashMap<String, String> directions) {
            this.directions = directions;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getItems() {
            return item;
        }

        public void setItems(List<String> item) {
            this.item = item;
        }
    }

    private static class Armory extends LocationLayout {
        public Armory() {

        }
    }

    private static class Cafeteria extends LocationLayout {
        public Cafeteria() {

        }
    }

    private static class Area51 extends LocationLayout {
        public Area51() {

        }
    }

    private static class PortalRoom extends LocationLayout {
        public PortalRoom() {

        }
    }

    private static class Amazon extends LocationLayout {
        public Amazon() {

        }
    }

    public static class Dubai extends LocationLayout {
        public Dubai() {

        }
    }

    private static class Uzbekistan extends LocationLayout {
        public Uzbekistan() {

        }
    }

    private static class Greenland extends LocationLayout {
        public Greenland() {

        }
    }

    private static class Laboratory extends LocationLayout {
        public Laboratory() {
        }
    }

}
