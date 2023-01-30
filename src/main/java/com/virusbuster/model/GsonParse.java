package com.virusbuster.model;


import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonParse {
    public static void main(String[] args) {

        //Create GameMap
        GameMap gameMap = new GameMap();
        try(Reader reader = new FileReader("src/main/resources/data/location.json")){
            gameMap = new Gson().fromJson(reader, GameMap.class);
            GameMap.Area51 area51 = gameMap.getArea51();
            GameMap.Cafeteria cafeteria = gameMap.getCafeteria();
            System.out.println("Your current location:" + area51.getName() + "Cafeteria: " + cafeteria.getItems());

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
