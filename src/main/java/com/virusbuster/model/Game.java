package com.virusbuster.model;

import com.google.gson.Gson;
import com.virusbuster.view.View;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import static com.virusbuster.view.View.*;

public class Game {

    private static Commands verb;
    private static GameMap.LocationLayout currentLocation;
    private static String noun;
    private static View view;
    public static GameMap gameWorld;
    public static Player player = new Player();




    //private static final String startingLocation = "Area51";
    private static List<String> items = new ArrayList<>(Arrays.asList("CAMU CAMU", "CAMEL MILK", "SUMALAK", "GLACIER MAGICAL PLANT"));



    public Game() {
    }


    public static void gameTest() {

        player.setName(Player.promptForName());

        displayLocation(player);
        boolean inputVaild = false;
        while (!inputVaild) {
            System.out.println('↓');
            String[] moveInput = commandInput().toUpperCase().split(" ", 2);


            if ("go".equalsIgnoreCase(moveInput[0])){

                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);

            } else if ("get".equalsIgnoreCase(moveInput[0])){

                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
            }
            else if ("enter".equalsIgnoreCase(moveInput[0])){
                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
            }
            else if ("trade".equalsIgnoreCase(moveInput[0])){

                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
            }
            else if ("talk".equalsIgnoreCase(moveInput[0])){

                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
            }
            else if ("look".equalsIgnoreCase(moveInput[0])){

                verb = validCommand(moveInput[0]);
                noun = moveInput[1];
                inputVaild = isValid(noun);
            }
            else if ("help".equalsIgnoreCase(moveInput[0])){
                commandsHelp();
            }
            else if ("quit".equalsIgnoreCase(moveInput[0])){
                exitMessage();
                System.exit(0);
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
            System.out.printf("Your input was [%s, %s]",verb, noun);
            return true;
        } else {
            System.out.printf("Sorry, [%s, %s] is not a valid. See below for valid inputs.", verb,  noun);
            commandsHelp();
            return false;
        }
    }


    private static Commands[] values() {
        return Commands.values();
    }

    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    //parses the location
    public void generateWorld() {
        try (Reader reader = new FileReader("src/main/resources/data/location.json")) {
            gameWorld = new Gson().fromJson(reader, GameMap.class);
            player.setCurrentLocation(gameWorld.getArea51());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayLocation(Player player){
        String currentLocation = player.getCurrentLocation().getName();
        List<String> items = player.getCurrentLocation().getItems();
        HashMap<String,String> directions = player.getCurrentLocation().getDirections();
        System.out.printf("\n\n%s, you are located at: %s \nitems: %s \ndirections: %s\n",
                player.getName(),currentLocation,items,directions);
    }
}


