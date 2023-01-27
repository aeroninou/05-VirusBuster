package com.virusbuster.model;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.virusbuster.view.View.*;

public class Game {

    private static Commands verb;
    private static GameMap.LocationLayout currentLocation;
    private static String noun;
    public static Game game = new Game();
    public static GameMap gameWorld;

    //private static final String startingLocation = "Area51";
    private static List<String> items = new ArrayList<>(Arrays.asList("camu camu", "zippo lighter", "silver pen", "sumalak", "glacier magical plant"));


    public Game() {


    }

    public GameMap.LocationLayout getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(GameMap.LocationLayout currentLocation) {
        Game.currentLocation = currentLocation;
    }

    public static void gameTest() {
        displayLocation(game);
        boolean inputVaild = false;
        while (!inputVaild) {
            System.out.println('>');
            String[] moveInput = commandInput().toLowerCase().split(" ", 2);

            if ("look".equals(moveInput[0])) {
                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
                System.out.println("You input was " + moveInput[0]);

            } else if ("bag".equals(moveInput[0])) {
                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
                System.out.println("You chose " + verb);
            }
        }
    }

    private static Commands validCommand(String input) {
        Commands result = null;
        for (Commands command : values()) {
            if (command.getValue().equalsIgnoreCase(input)) {
                result = command;
                break;
            }
        }
        return result;
    }

    private static boolean isValid(String input) {
        if (items.contains(input)) {
            return true;
        } else {
            System.out.println("Sorry, that is not a valid item.");
            return false;
        }
    }


    private static Commands[] values() {
        return Commands.values();
    }

    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        return input;
    }
    //parses the location
    public static void generateWorld() {
        try (Reader reader = new FileReader("src/main/resources/data/location.json")) {
            gameWorld = new Gson().fromJson(reader, GameMap.class);
            game.setCurrentLocation(gameWorld.getArea51());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


