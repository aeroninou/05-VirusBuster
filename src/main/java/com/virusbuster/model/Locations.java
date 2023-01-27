package com.virusbuster.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Locations {
    //key from the location.json
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("north")
    @Expose
    private String north;

    @SerializedName("south")
    @Expose
    private String south;

    @SerializedName("west")
    @Expose
    private String west;

    @SerializedName("east")
    @Expose
    private String east;

    @SerializedName("item")
    @Expose
    private List<String> item = null;

    @SerializedName("description")
    @Expose
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
