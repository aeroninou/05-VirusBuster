package com.virusbuster.model;


import com.apps.util.Console;
import com.google.gson.Gson;
import com.virusbuster.view.View;
import jdk.jshell.execution.LoaderDelegate;

import java.io.*;
import java.util.*;


public class Game {

    private String verb;
    private String noun;
    //private GameMap.LocationLayout currentLocation;

    private static final String INVALID_INPUT_TRY_AGAIN_TYPE_HELP_FOR_ASSISTANCE = "Invalid input,[%s, %s] please try again. Type 'help' for assistance\n";
    private static final String ERROR_MESSAGE_ENTER_2_WORDS_FOR_COMMAND = "Error! Enter 2 words for command.";
    private static final String ITEMS_JSON = "data/items.json";
    private static final String LOCATIONS_JSON = "data/testLocation.json";
    private static final String CHARACTERS_JSON = "data/characters.json";

    private static final String STARTING = "Area51";

    private static final String PATH = "src/main/resources/gamedata/playerData.txt";

    public List<GameItem.ItemInformation> gameItems;
    public static Character character = new Character();
    public final  View view;
    public static GameItem item = new GameItem();
    //public GameMap gameWorld;
    public Player player = new Player();

    //loads the json
    private final Map<String,Location> locationMap = Location.loadLocation(LOCATIONS_JSON);

    public Game(View view) {
        this.view = view;
    }

    private final List<String> items = new ArrayList<>(Arrays.asList("camu camu", "camel milk", "sumalak", "raincoat", "glacier magical plant",
            "bubble gum", "jack daniels", "ice container", "gold rolex watch", "zippo lighter", "east",
            "west", "north", "south", "room1", "room2", "room3", "room4", "player", "dr. ww", "chief", "prince", "local vendor", "farmer"));

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
        if (result.size() == 1 && "save".equalsIgnoreCase(verb)) {
            return result;
        }
        if (result.size() == 1 && "load".equalsIgnoreCase(verb)) {
            return result;
        }
        else if (result.size() != 2) {
            System.out.println(ERROR_MESSAGE_ENTER_2_WORDS_FOR_COMMAND);
            result.set(0, "invalid");
            view.promptEnterKey();
            return result;

        }

        //checking both inputs if either one is invalid will print message and assign 0 index to invalid.
        if ( verb == null || !items.contains(result.get(1))) {
            System.out.printf(INVALID_INPUT_TRY_AGAIN_TYPE_HELP_FOR_ASSISTANCE, result.get(0), result.get(1));
            result.set(0, "invalid");
            view.promptEnterKey();
        }
        return result;
    }

    //game method
    public void startGame() {
        loadsLocation();
        //prompt for name and set player name
        player.setName(player.promptForName());
        player.setCurrentLocation(STARTING);
        //display current location
        displayLocation(player);
        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("\n↓");
            String moveInput = commandInput();
            List<String> moveCommand = parseCommand(moveInput);

            while ("invalid".equalsIgnoreCase(moveCommand.get(0))) {
                displayLocation(player);
                System.out.println("\n↓");
                moveInput = commandInput();
                moveCommand = parseCommand(moveInput);
            }
            if ("help".equalsIgnoreCase(moveCommand.get(0))) {
                view.commandsHelp();
            } else if ("quit".equalsIgnoreCase(moveCommand.get(0))){
                view.exitMessage();
            } //else if ("save".equalsIgnoreCase(moveCommand.get(0))){
//                view.exitMessage();
//            else if ("load".equalsIgnoreCase(moveCommand.get(0))){
//                option.loadGame();
           else {
                executeCommand(moveCommand);
            }
            displayLocation(player);
        }
    }

    // execute parsed command based on verb and noun
    private void executeCommand(List<String> command) {
        String verb = command.get(0);
        String noun = command.get(1);
        switch (verb) {
            case "go":
                move(noun);
                break;
//            case "get":
//            case "grab":
//            case "pickup":
//            case "take":
//                putItemInBag(noun);
//                break;
//            case "drop":
//                dropItem(noun);
//                break;
//            case "look":
//                lookItem(noun);
//                break;
//            case "talk":
//                talkToNPC(noun);
//                break;
            default:
                System.out.println("Invalid in ExecuteCommand");
        }
    }

    //Checking if the commands are valid from Commands enums
    private static String validCommand(String input) {
        String result = null;
        for (Command command : values()) {
            if (command.getValue().equalsIgnoreCase(input)) {
                result = command.getValue();
                break;
            }
        }
        return result;
    }

    //returning the values of the Command enum
    private static Command[] values() {
        return Command.values();
    }

    //prompt user for verb and nouns
    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //loads the location from location.json(parsing it)
    private void loadsLocation() {
        Location.loadLocation(LOCATIONS_JSON);
        loadCharacter();
        loadItemsFromJSONFile();
    }

    //loads the Characters from characters.json
    private void loadCharacter() {
        jsonLoader(CHARACTERS_JSON);
    }

    //loads all items from JSON file.
    private void loadItemsFromJSONFile() {
        jsonLoader(ITEMS_JSON);
    }

    //loads the json via different filepath
    private void jsonLoader(String filePath) {
        //noinspection ConstantConditions
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
             Reader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if(Objects.equals(filePath, ITEMS_JSON)){
                item = new Gson().fromJson(reader, GameItem.class);
                gameItems = item.loadAllItems();
        } else if (Objects.equals(filePath, CHARACTERS_JSON)){
                character = new Gson().fromJson(reader, Character.class);
            }
//            else if (Objects.equals(filePath, LOCATIONS_JSON)){
//                gameWorld = new Gson().fromJson(reader, GameMap.class);
//                player.setCurrentLocation(gameWorld.getArea51());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* Action verb methods */

    //sets the new location of the player
    private void move(String direction) {

        //sets the player location
        Location currentLocation = locationMap.get(player.getCurrentLocation());
        //input from player for the next location
        String nextLocation = currentLocation.getDirections().get(direction);
        if (nextLocation == null) {
            System.out.println("You cannot go that way");
        } else {
            player.setCurrentLocation(nextLocation);
        }
    }

    //drops item
//    private void dropItem(String noun) {
//        Location currentLocation = player.getCurrentLocation();
//        List<GameItem.ItemInformation> bag = player.getBag();
//        GameItem.ItemInformation singleItem = findTheItemByNoun(noun);
//        if (bag == null || bag.size() == 0) {
//            System.out.println("Nothing to drop");
//        } else if (singleItem == null) {
//            System.out.printf("Can't pick this %s at %s.", noun, currentLocation);
//        } else if (bag.contains(singleItem)) {
//            player.dropFromBag(singleItem);
//            currentLocation.getItems().add(noun);
//        } else {
//            System.out.printf("[%s] is not a valid command at %s. ", noun, currentLocation);
//        }
//    }

    //gets item
//    private void putItemInBag(String noun) {
//        GameMap.LocationLayout currentLocation = player.getCurrentLocation();
//        List<String> itemList = player.getCurrentLocation().getItems();
//
//        GameItem.ItemInformation singleItem = findTheItemByNoun(noun);
//
//        if (singleItem == null) {
//            System.out.printf("Can't pick this %s at %s.", noun, currentLocation);
//
//        } else if (itemList.contains(noun)){
//
//            player.addToBag(singleItem);
//
//            for (int i = 0; i < itemList.size(); i++){
//                if (noun.equalsIgnoreCase(itemList.get(i))){
//                    currentLocation.getItems().remove(i);
//                }
//            }
//        }
//        else {
//            System.out.printf("[%s] is not a valid command at %s. ", noun, currentLocation);
//        }
//    }
//
//    //look function
//    private void lookItem(String noun) {
//        GameMap.LocationLayout currentLocation = player.getCurrentLocation();
//        List<String> itemList = player.getCurrentLocation().getItems();
//
//        GameItem.ItemInformation singleItem = findTheItemByNoun(noun);
//
//        if (singleItem == null) {
//            System.out.printf("Can't find %s at %s.", noun, currentLocation);
//        }
//        else if (itemList.contains(noun)) {
//            System.out.printf("%s --> %s \n", noun, singleItem.getDescription());
//            view.promptEnterKey();
//        }
//    }
//
//    private GameItem.ItemInformation findTheItemByNoun(String noun) {
//        for (GameItem.ItemInformation item : gameItems) {
//            if (noun.equalsIgnoreCase(item.getName())) {
//                return item;
//            }
//        }
//        return null;
//    }


    //look function
//    private void lookItem(String noun) {
//        GameMap.LocationLayout currentLocation = player.getCurrentLocation();
//        List<String> itemList = player.getCurrentLocation().getItems();
//
//        GameItem.ItemInformation singleItem = findTheItemByNoun(noun);
//
//        if (singleItem == null) {
//            System.out.printf("Can't find %s at %s.", noun, currentLocation);
//        }
//        else if (itemList.contains(noun)) {
//            System.out.printf("%s --> %s \n", noun, singleItem.getDescription());
//            view.promptEnterKey();
//        }
//    }

    private GameItem.ItemInformation findTheItemByNoun(String noun) {
        for (GameItem.ItemInformation item : gameItems) {
            if (noun.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public void displayLocation(Player player) {

        //will clear at the top and print the location
        Console.clear();
        String currentLocation = player.getCurrentLocation();
        String description = locationMap.get(currentLocation).getDescription();
        List<String> item = locationMap.get(currentLocation).getItem();

        HashMap<String, String> directions = locationMap.get(currentLocation).getDirections();

        System.out.printf("\n%s, Your bag has: [%s] \nYou are located at: %s \nAvailable Items: %s \nDirections: %s \nLocation Info: %s\n",
                player.getName(), player.stringOfCurrentBagItems(), currentLocation, item, directions, description);

        //displayCharacter(currentLocation);
    }

//    private static void displayCharacter(String currentLocation) {
//        //initialize Characters to utilize attributes
//        Character.NPC1 npc1 = character.getNpc1();
//        Character.NPC2 npc2 = character.getNpc2();
//        Character.NPC3 npc3 = character.getNpc3();
//        Character.NPC4 npc4 = character.getNpc4();
//        Character.NPC5 npc5 = character.getNpc5();
//
//
//        if (currentLocation.equals(npc1.getLocation())) {
//            System.out.printf("You see : %s", npc1.getName());
//        } else if (currentLocation.equals(npc2.getLocation())) {
//            System.out.printf("You see The : %s", npc2.getName());
//        } else if (currentLocation.equals(npc3.getLocation())) {
//            System.out.printf("You see The : %s", npc3.getName());
//        } else if (currentLocation.equals(npc4.getLocation())) {
//            System.out.printf("You see a : %s", npc4.getName());
//        } else if (currentLocation.equals(npc5.getLocation())) {
//            System.out.printf("You see a : %s", npc5.getName());
//        } else {
//            System.out.println("You see no one in this location");
//        }
//    }

    //TODO:needs refactor later
//    private void talkToNPC(String name){
//
//        String currentLocation = player.getCurrentLocation().getName();
//
//        //initialize Characters to utilize attributes
//        Character.NPC1 npc1 = character.getNpc1();
//        Character.NPC2 npc2 = character.getNpc2();
//        Character.NPC3 npc3 = character.getNpc3();
//        Character.NPC4 npc4 = character.getNpc4();
//        Character.NPC5 npc5 = character.getNpc5();
//        Character.User user = character.getPlayer();
//
//
//        List<String> test = user.getQuote();
//
//        if (name.equals(npc1.getName()) && Objects.equals(currentLocation, npc1.getLocation())) {
//            System.out.printf("%s: %s", npc1.getName(), npc1.getQuote().get(0));
//        } else if (name.equals(npc2.getName()) && Objects.equals(currentLocation, npc2.getLocation())) {
//            System.out.printf("%s: %s\n", npc2.getName(), npc2.getQuote().get(0));
//            System.out.printf("%s: %s\n", player.getName(), test.get(0));
//
//        } else if (name.equals(npc3.getName()) && Objects.equals(currentLocation, npc3.getLocation())) {
//            System.out.printf("%s: %s\n", npc3.getName(), npc3.getQuote().get(0));
//            System.out.printf("%s: %s\n", player.getName(), test.get(1));
//
//        } else if (name.equals(npc4.getName()) && Objects.equals(currentLocation, npc4.getLocation()))  {
//            System.out.printf("%s: %s\n", npc4.getName(), npc4.getQuote().get(0));
//            System.out.printf("%s: %s\n", player.getName(), test.get(2));
//
//        } else if (name.equals(npc5.getName()) && Objects.equals(currentLocation, npc4.getLocation()))  {
//            System.out.printf("%s: %s\n", npc5.getName(), npc5.getQuote().get(0));
//            System.out.printf("%s: %s\n", player.getName(), test.get(3));
//
//        } else {
//            System.out.printf("No one here to talk with. %s isn't here.", name);
//        }
//        System.out.println("You must [trade] an item in your bag based on the Location Info.");
//        view.promptEnterKey();
//    }
}


