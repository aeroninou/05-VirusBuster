package com.virusbuster.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class GsonParse {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (InputStream inputStream = Location.class.getClassLoader().getResourceAsStream("data/testLocation.json");
             Reader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            Type type = new TypeToken<List<Location>>(){}.getType();
            List<Location> location = gson.fromJson(reader,type);
            for(Location location1 : location){
                System.out.println(location1.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
