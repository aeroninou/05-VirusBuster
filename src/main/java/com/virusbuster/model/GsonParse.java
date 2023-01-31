package com.virusbuster.model;


import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonParse {
    public static void main(String[] args) {

        //Create GameMap
        GameMap gameMap = new GameMap();
        //Create Character
        Character character = new Character();
        //testing location json
        try(Reader reader = new FileReader("src/main/resources/data/location.json")){
            gameMap = new Gson().fromJson(reader, GameMap.class);
            GameMap.LocationLayout area51 = gameMap.getArea51();
            GameMap.LocationLayout cafeteria = gameMap.getCafeteria();
            System.out.println("Your current location:" + area51.getName() + "Cafeteria: " + cafeteria.getItems());

        }catch(IOException e){
            e.printStackTrace();
        }

        //testing character json
        try(Reader reader = new FileReader("src/main/resources/data/characters.json")){
            character = new Gson().fromJson(reader, Character.class);
            Character.NPC1 npc1 = character.getNpc1();
            System.out.printf("NPC: %s Quote: %s",npc1.getName(), npc1.getQuote());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
