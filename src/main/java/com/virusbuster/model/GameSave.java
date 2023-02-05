package com.virusbuster.model;

import java.io.*;
import java.util.List;
import java.util.Map;

public class GameSave {
    private final Game game;

    public GameSave(Game game){
        this.game=game;

    }
    public void saveGame(){
        try{
            FileOutputStream saveFile = new FileOutputStream("src/main/resources/gamedata/Game.sav");
            ObjectOutputStream status = new ObjectOutputStream(saveFile);
            status.writeObject(game.player);
            status.writeObject(game.locationMap);
            status.writeObject((game.portalUse));
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
            game.player = (Player) status.readObject();
            //noinspection unchecked
            game.locationMap = (Map<String, Location>) status.readObject();
            game.portalUse = (int) status.readObject();
            player.setCurrentLocation(this.game.player.getCurrentLocation());
            player.setBag(this.game.player.getBag());
            player.setName(this.game.player.getName());
            //player.setPortalUsage(this.game.player.getPortalUsage());
            System.out.println("Game Loaded\n");
        } catch (Exception e) {
            System.out.println("Can't load game\n");
        }
    }
}
