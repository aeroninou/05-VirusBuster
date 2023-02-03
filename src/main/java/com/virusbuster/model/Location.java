package com.virusbuster.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Location {
    private String name;
    private HashMap<String, String> directions;
    private String description;
    private List<String> item;

    public Location(String name, HashMap<String, String> directions, String description, List<String> item) {
        this.name = name;
        this.directions = directions;
        this.description = description;
        this.item = item;
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

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", directions=" + directions +
                ", description='" + description + '\'' +
                ", item=" + item +
                '}';
    }

    public static Map<String, Location> loadLocation(String jsonPath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(Location.class.getClassLoader().
                getResourceAsStream(jsonPath)))) {
            Type locationListType = new TypeToken<List<Location>>() {}.getType();
            List<Location> locationList = gson.fromJson(reader, locationListType);
            return locationList.stream().collect(Collectors.
                    toMap(location -> location.getName(), location -> location ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

