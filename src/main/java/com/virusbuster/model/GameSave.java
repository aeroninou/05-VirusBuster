package com.virusbuster.model;

import java.io.*;

public class GameSave {
    private Player player;
    public GameSave(Player player){
        this.player=player;
    }
    public void saveGame(){
        try{
            FileOutputStream saveFile = new FileOutputStream("src/main/resources/gamedata/Game.sav");
            ObjectOutputStream status = new ObjectOutputStream(saveFile);
            status.writeObject(player);
            status.flush();
            status.close();
            System.out.println("Game saved\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadGame(Player player){
        try{
            FileInputStream loadFile = new FileInputStream("src/main/resources/gamedata/Game.sav");
            ObjectInputStream status = new ObjectInputStream(loadFile);
            player = (Player) status.readObject();
            this.player.setCurrentLocation(player.getCurrentLocation());
            this.player.setName(player.getName());
            this.player.setBag(player.getBag());
            System.out.println("Game Loaded\n");
        } catch (Exception e) {
            System.out.println("Can't load game\n");
        }
    }
}
