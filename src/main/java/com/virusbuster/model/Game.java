package com.virusbuster.model;


import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.virusbuster.view.View;

import java.io.*;
import java.util.*;

public class Game {

    private String verb;
    private String noun;
    private GameMap.LocationLayout currentLocation;


    public static Character character = new Character();
    public static View view = new View();
    public GameMap gameWorld;
    public Player player = new Player();

    public Game() {
    }

    private List<String> items = new ArrayList<>(Arrays.asList("camu camu", "camel milk", "sumalak", "raincoat", "glacier magical plant",
            "bubble gum", "jack daniels", "ice container", "gold rolex watch", "east", "west", "north", "south", "room1", "room2", "room3", "room4"));
    //private List<String> commands = new ArrayList<>(Arrays.asList("go", "get", "enter", "trade", "talk", "bag", "quit", "help", "look"));

    //parsing user's inout
    public List<String> parseCommand(String wordInput) {
        List<String> result = new ArrayList<>(Arrays.asList(wordInput.toLowerCase().trim().split(" ", 2)));

        verb = validCommand(result.get(0));
        noun = noun;

        if (result.size() == 1 && "help".equalsIgnoreCase(verb)) {
            return result;
        }
        if (result.size() == 1 && "quit".equalsIgnoreCase(verb)) {
            return result;
        }
        else if (result.size() != 2) {
            System.out.println("Error! Enter 2 words for command.");
            result.set(0, "invalid");
            return result;
        }

        //checking both inputs if either one is invalid will print message and assign 0 index to invalid.
        if ( verb == null || !items.contains(result.get(1))) {
            System.out.printf("Invalid input,[%s, %s] please try again. Type 'help' for assistance\n", result.get(0), result.get(1));
            result.set(0, "invalid");
        }
        return result;
    }

    //game method
    public void gameTest() {
        //prompt for name and set player name
        player.setName(player.promptForName());
        loadsLocation();
        //display current location
        displayLocation(player);
        boolean inputVaild = false;
        while (!inputVaild) {
            System.out.println("\n↓");
            String moveInput = commandInput();
            List<String> moveCommand = parseCommand(moveInput);

            while ("invalid".equalsIgnoreCase(moveCommand.get(0))) {
                displayLocation(player);
                System.out.println("\n↓");
                moveInput = commandInput();
                moveCommand = parseCommand(moveInput);
            }

            if ("help".equalsIgnoreCase(moveCommand.get(0))){
                view.commandsHelp();
            } else if ("quit".equalsIgnoreCase(moveCommand.get(0))){
                view.exitMessage();
                System.exit(0);
            } else {
                move(moveCommand.get(1));
            }
            displayLocation(player);
        }
    }

    //Checking if the commands are valid from Commands enums
    private static String validCommand(String input) {
        String result = null;
        for (Commands command : values()) {
            if (command.getValue().equalsIgnoreCase(input)) {
                result = command.getValue();
                break;
            }
        }
        return result;
    }

    //returning the values of the Command enum
    private static Commands[] values() {
        return Commands.values();
    }

    //prompt user for verb and nouns
    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    //sets the new location of the player
    private void move(String direction) {
        //sets the player location
        GameMap.LocationLayout currentLocation = player.getCurrentLocation();
        //input from player for the next location
        GameMap.LocationLayout nextLocation = gameWorld.getLocation(currentLocation.getDirections().get(direction));
        if (nextLocation == null) {
            System.out.println("You cannot go that way");
        } else {
            player.setCurrentLocation(nextLocation);
        }
    }


    //loads the location from location.json(parsing it)
    private void loadsLocation() {
        //noinspection ConstantConditions
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/location.json");
             Reader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            gameWorld = new Gson().fromJson(reader, GameMap.class);
            player.setCurrentLocation(gameWorld.getArea51());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadCharacter();
    }

    //loads the Characters from characters.json
    private void loadCharacter(){
        //noinspection ConstantConditions
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/characters.json");
             Reader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            character = new Gson().fromJson(reader, Character.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayLocation(Player player) {
        String currentLocation = player.getCurrentLocation().getName();
        List<String> item = player.getCurrentLocation().getItems();

        HashMap<String, String> directions = player.getCurrentLocation().getDirections();

        //initialize Characters to utilize attributes
        Character.NPC1 npc1 = character.getNpc1();
        Character.NPC2 npc2 = character.getNpc2();
        Character.NPC3 npc3 = character.getNpc3();
        Character.NPC4 npc4 = character.getNpc4();
        Character.NPC5 npc5 = character.getNpc5();

        System.out.printf("\n%s, You are located at: %s \nitems: %s \ndirections: %s\n",
                player.getName(), currentLocation, item, directions);

        if(currentLocation.equals(npc1.getLocation())){
            System.out.printf("You see : %s",npc1.getName());
        }else if(currentLocation.equals(npc2.getLocation())){
            System.out.printf("You see The : %s",npc2.getName());
        }else if(currentLocation.equals(npc3.getLocation())){
            System.out.printf("You see The : %s",npc3.getName());
        } else if (currentLocation.equals(npc4.getLocation())){
            System.out.printf("You see a : %s",npc4.getName());
        } else if(currentLocation.equals(npc5.getLocation())){
            System.out.printf("You see a : %s",npc5.getName());
        } else {
            System.out.println("You see no one in this location");
        }
    }
}


