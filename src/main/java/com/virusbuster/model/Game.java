package com.virusbuster.model;


import com.apps.util.Console;
import com.virusbuster.view.View;

import java.util.*;


public class Game {

    private String verb;
    private String noun;

    private static final String ERROR_MESSAGE_ENTER_2_WORDS_FOR_COMMAND = "Error! Enter 2 words for command.";
    private static final String ITEMS_JSON = "data/items.json";
    private static final String LOCATIONS_JSON = "data/location.json";
    private static final String CHARACTERS_JSON = "data/characters.json";
    private static final String STARTING = "Area51";

    //public static Character character = new Character();
    public final View view;

    //public GameMap gameWorld;
    public Player player = new Player();

    //loads the json
    private final Map<String,Location> locationMap = Location.loadLocation(LOCATIONS_JSON);
    private final Map<String,Character> characterMap = Character.loadCharacter(CHARACTERS_JSON);
    //loads the items json
    private final Map<String, String> mapItem = Item.loadItems(ITEMS_JSON);


    public Game(View view) {
        this.view = view;
    }

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
        if (result.size() == 1 && "map".equalsIgnoreCase(verb)) {
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
        return result;
    }

    //game method
    public void startGame() {
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
            } else if ("map".equalsIgnoreCase(moveCommand.get(0))){
                view.displayEmptyMap();
            } else {
                executeCommand(moveCommand);
            }
            displayLocation(player);
        }
    }

    //TODO:MUST CREATE LOGIC FOR JSON CASE MATCHING WITH INPUT

    // execute parsed command based on verb and noun
    private void executeCommand(List<String> command) {
        String verb = command.get(0);
        String noun = command.get(1);
        switch (verb) {
            case "go":
                move(noun);
                break;
            case "get":
            case "grab":
            case "pickup":
            case "take":
                putItemInBag(noun);
                break;
            case "drop":
                dropItem(noun);
                break;
            case "look":
                lookItem(noun);
                break;
            case "talk":
                talkToNPC(noun);
                break;
            case "see":
                //fx;
                break;
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
    private void dropItem(String noun) {

        Location currentLocation = locationMap.get(player.getCurrentLocation());
        List<String> currentBag = player.getBag();

        if (currentBag == null || currentBag.size() == 0) {
            System.out.println("Nothing to drop");
        } else if (currentBag.contains(noun)) {
            player.dropFromBag(noun);
            currentLocation.getItem().add(noun);
        } else {
            System.out.printf("[%s] is not a valid command at %s. ", noun, currentLocation.getName());
        }
    }

    //gets item
    private void putItemInBag(String noun) {
        Location currentLocation = locationMap.get(player.getCurrentLocation());


        boolean singleItem = mapItem.containsKey(noun);
        boolean isItemInCurrentLocation = currentLocation.getItem().contains(noun);

        if (singleItem && isItemInCurrentLocation) {
            player.addToBag(noun);
            currentLocation.getItem().remove(noun);
        }
        else {
            System.out.printf("[%s] is not a at %s. ", noun, currentLocation.getName());
        }
    }


    //look function
    private void lookItem(String noun) {
        Location currentLocation = locationMap.get(player.getCurrentLocation());

        boolean singleItem = mapItem.containsKey(noun);
        boolean isItemInCurrentLocation = currentLocation.getItem().contains(noun);


        if (singleItem && isItemInCurrentLocation) {
            System.out.printf("%s --> %s \n", noun, mapItem.get(noun));
            view.promptEnterKey();
        } else if (singleItem && player.getBag().contains(noun)){
            System.out.printf("%s --> %s \n", noun, mapItem.get(noun));
            view.promptEnterKey();
        } else {
            System.out.printf("Can't look at [%s], item not at %s or in your bag.", noun, currentLocation.getName());
        }
    }


    public void displayLocation(Player player) {

        //will clear at the top and print the location
        Console.clear();
        String currentLocation = player.getCurrentLocation();
        String description = locationMap.get(currentLocation).getDescription();
        List<String> item = locationMap.get(currentLocation).getItem();

        Map<String, String> directions = locationMap.get(currentLocation).getDirections();

        System.out.printf("\n%s, Your bag has: [%s] \nYou are located at: %s \nAvailable Items: %s \nDirections: %s \nLocation Info: %s\n",
                player.getName(), player.printCurrentBag(), currentLocation, item, directions, description);

        displayCharacter(currentLocation);
    }

    private  void displayCharacter(String currentLocation) {
        for (Map.Entry<String, Character> entry : characterMap.entrySet()) {
            if (currentLocation.equalsIgnoreCase(entry.getKey())) {
                System.out.printf("You see the : %s", entry.getValue().getName());
            }
        }
        if(!characterMap.containsKey(currentLocation)){
            System.out.println("You see no one in this location");
        }
    }

//    private void displayMap(String currentLocation) {
//        for (Map.Entry<String>, C)
//
//    }



    private void talkToNPC(String name){
        String currentLocationName = locationMap.get(player.getCurrentLocation()).getName();
        String characterName = characterMap.get(currentLocationName).getName();

        for (Map.Entry<String, Character> entry : characterMap.entrySet()) {
            String charName = entry.getValue().getName();
            if (name.equalsIgnoreCase(charName)) {
                System.out.printf("%s : %s", name, entry.getValue().getQuotes());
                System.out.println("\nYou must [trade] an item in your bag based on the Location Info.");
            }
        }
        if(!name.equalsIgnoreCase(characterName)){
            System.out.printf("\nNo one here to talk with. %s isn't here.", name);
        }
        view.promptEnterKey();
    }
}
