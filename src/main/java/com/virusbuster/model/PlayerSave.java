package com.virusbuster.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PlayerSave {
    private final Path playerInfo;
    private final String path = "src/main/resources/gamedata/playerData.txt";
    private final File filepath = new File(path);


    public PlayerSave(String playerInfo) {
        this.playerInfo = Path.of(playerInfo);
    }

    public boolean checkPlayer(Player player) {
        String name = player.getName();

        try {
            if (!filepath.exists()) {
                //noinspection ResultOfMethodCallIgnored
                filepath.createNewFile();
            }
            List<String> lines = Files.readAllLines(Path.of(path));
            //if file is empty, will add the new player name
            if (lines.isEmpty()) {
                savePlayer(name);
                lines.add(name);
                //checks if the player is inside the playerData.txt
            } else if (lines.contains(name)) {
                System.out.printf("\nWelcome back : %s", name);
                return true;
            } else {
                savePlayer(name);
                lines.add(name);
            }

        } catch (IOException e) {
            System.out.println("Cannot save player's name");
        }
        return false;
    }

    //adds a player to the file
    public void savePlayer(String playerName) {
        try (PrintWriter addPlayerName = new PrintWriter(new FileWriter(playerInfo.toFile(), true))) {
            addPlayerName.println((playerName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
