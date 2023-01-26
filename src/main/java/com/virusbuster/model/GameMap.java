package com.virusbuster.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class GameMap {
    @SerializedName("locations")
    @Expose
    private List<Locations> locations = null;

    public List<Locations> getLocations(){
        return locations;
    }

    public void setLocation(List<Locations> locations){
        this.locations = locations;
    }
    public GameMap displayLocation(){
        //create a GSON object for parsing data
        Gson gson = new Gson();
        BufferedReader br = null;
        GameMap location = null;
        try{
            br= new BufferedReader(new FileReader("src/main/resources/data/location.json"));
            location = gson.fromJson(br, GameMap.class);

            if(location != null){
                for(Locations l : location.getLocations()){
                    System.out.printf("Name: %s Description: %s  item: %s", l.getName(), l.getDescription(), l.getItem());
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } finally{
            if(br!=null){
                try{
                    br.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return location;
    }

}
