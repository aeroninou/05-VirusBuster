package com.virusbuster.model;


import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.virusbuster.view.View;

import java.io.*;
import java.util.*;

public class Game {

<<<<<<< Updated upstream
    private String verb;
    private GameMap.LocationLayout currentLocation;
    private String noun;
    private View view;
    public GameMap gameWorld;
    public Player player = new Player();
    public static Character character = new Character();
=======
<<<<<<< Updated upstream
    private static String verb;
    private static GameMap.LocationLayout currentLocation;
    private static String noun;
    private static View view;
    public static GameMap gameWorld;
    public static Player player = new Player();
=======
    private String verb;
    private GameMap.LocationLayout currentLocation;
    private String noun;
    public static View view = new View();
    public GameMap gameWorld;
    public Player player = new Player();
>>>>>>> Stashed changes
>>>>>>> Stashed changes

    public Game() {
    }

<<<<<<< Updated upstream
    private List<String> items = new ArrayList<>(Arrays.asList("CAMU CAMU", "CAMEL MILK", "SUMALAK", "RAINCOAT", "GLACIER MAGICAL PLANT", "BUBBLE GUM", "JACK DANIELS", "ICE CONTAINER", "GOLD ROLEX WATCH"));
    private List<String> commands = new ArrayList<>(Arrays.asList("GO", "GET", "ENTER", "TRADE", "TALK", "BAG", "QUIT", "HELP", "LOOK"));
=======
<<<<<<< Updated upstream
    private static List<String> items = new ArrayList<>(Arrays.asList("CAMU CAMU", "CAMEL MILK", "SUMALAK", "RAINCOAT", "GLACIER MAGICAL PLANT"));
    private static List<String> commands = new ArrayList<>(Arrays.asList("GO", "GET", "ENTER", "TRADE", "TALK", "BAG", "QUIT", "HELP"));
>>>>>>> Stashed changes

    //parsing user's inout
    public void parseCommand(List<String> wordlist) {

        if ("help".equalsIgnoreCase(wordlist.get(0))) {
            System.out.println("See above for valid commands");
        } else if (wordlist.size() != 2) {
            System.out.println("Error! Enter 2 words for command");
        } else {
            verb = String.valueOf(validCommand(wordlist.get(0)));
<<<<<<< Updated upstream
            noun = wordlist.get(1).toLowerCase();
            //takes the noun of the user's input (e.g go east, noun = east)
            move(noun);
=======
            noun = wordlist.get(1);
=======
    private List<String> items = new ArrayList<>(Arrays.asList("camu camu", "camel milk", "sumalak", "raincoat", "glacier magical plant",
            "bubble gum", "jack daniels", "ice container", "gold rolex watch", "east", "west", "north", "south", "room1", "room2", "room3", "room4"));
    private List<String> commands = new ArrayList<>(Arrays.asList("go", "get", "enter", "trade", "talk", "bag", "quit", "help", "look"));
>>>>>>> Stashed changes

    //parsing user's inout
    public List<String> parseCommand(String wordInput) {
        List<String> result = new ArrayList<>(Arrays.asList(wordInput.toLowerCase().trim().split(" ")));

        verb = result.get(0);
        noun = "";
>>>>>>> Stashed changes

        if (result.size() == 1 && "help".equalsIgnoreCase(verb)) {
            return result;
        }
        if (result.size() == 1 && "quit".equalsIgnoreCase(verb)) {
            return result;
        }
        else if (result.size() != 2) {
            System.out.println("Error! Enter 2 words for command.\n");
            result.set(0, "invalid");
            return result;
        }
        if (!commands.contains(verb) || !items.contains(result.get(1))) {
            System.out.print("Invalid input, please try again. Type 'help' for assistance\n");
        }

        if (!commands.contains(verb)) {
            System.out.println(verb + " is not a valid verb");
            result.set(0, "invalid");
        }
        if (!items.contains(result.get(1))) {
            System.out.println(noun + " is not a valid noun!");
            result.set(0, "invalid");
        }

        return result;
    }

<<<<<<< Updated upstream
    //splits input string to define a set of delimeter characters
    public List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims, 2);

        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }

    //inout validation for user input
    public String runCommand(String inputstr) {
        List<String> wl;
        String s = "gucci";
        String lowstr = inputstr.trim().toUpperCase();

        if (!lowstr.equalsIgnoreCase("q")) {
            if (lowstr.equals(" ")) {
                s = "Enter a command";
            } else {
                wl = wordList(lowstr);
                parseCommand(wl);
            }
        }
        return s;
    }
=======
//    //splits input string to define a set of delimeter characters
//    public List<String> wordList(String input) {
//        String delims = "[ \t,.:;?!\"']+";
//        List<String> strlist = new ArrayList<>();
//        String[] words = input.split(delims, 2);
//
//        for (String word : words) {
//            strlist.add(word);
//        }
//        return strlist;
//    }

//    //inout validation for user input
//    public String runCommand(String inputstr) {
//        List<String> wl;
//        String s = "gucci";
//        String lowstr = inputstr.toUpperCase();
//
//        if (!lowstr.equalsIgnoreCase("q")) {
//            if (lowstr.equals(" ")) {
//                s = "Enter a command";
//            } else {
//                wl = wordList(lowstr);
//                parseCommand(wl);
//            }
//        }
//        return s;
//    }
>>>>>>> Stashed changes

    //game method
    public void gameTest() {
        //prompt for name and set player name
        player.setName(Player.promptForName());
        loadsLocation();
        //display current location
        displayLocation(player);
        boolean inputVaild = false;
        while (!inputVaild) {
            System.out.println("\n↓");
            String moveInput = commandInput();
<<<<<<< Updated upstream

=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
            if ("quit".equalsIgnoreCase(moveInput) || "q".equalsIgnoreCase(moveInput)) {
                view.exitMessage();
                System.exit(0);
            } else if ("help".equalsIgnoreCase(moveInput)) {
                view.commandsHelp();
                Console.pause(2000);
            }
            runCommand(moveInput);
<<<<<<< Updated upstream
            displayLocation(player);
=======
=======

            List<String> moveCommand = parseCommand(moveInput);
            if ("help".equalsIgnoreCase(moveCommand.get(0))){
                view.commandsHelp();
            } else if ("quit".equalsIgnoreCase(moveCommand.get(0))){
                view.exitMessage();
                System.exit(0);
            } else {
                move(moveCommand.get(1));
            }

            displayLocation(player);
>>>>>>> Stashed changes
>>>>>>> Stashed changes

            //move(runCommand(moveInput));

<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
            } else if ("get".equalsIgnoreCase(String.valueOf(verb))) {
                //inputVaild = isValid(noun);
>>>>>>> Stashed changes


<<<<<<< Updated upstream
//            if ("go".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//
//            } else if ("get".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//
//            } else if ("enter".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//
//            } else if ("trade".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//
//            } else if ("talk".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//
//            } else if ("look".equalsIgnoreCase(String.valueOf(verb))) {
//                //inputVaild = isValid(noun);
//            }
=======
            } else if ("trade".equalsIgnoreCase(String.valueOf(verb))) {
                //inputVaild = isValid(noun);

            } else if ("talk".equalsIgnoreCase(String.valueOf(verb))) {
                //inputVaild = isValid(noun);

            } else if ("look".equalsIgnoreCase(String.valueOf(verb))) {
                //inputVaild = isValid(noun);
            }
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
        }
    }

    //Checking if the commands are valid by looping Commands enums
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

    //getting the values of the Command enum
    private static Commands[] values() {
        return Commands.values();
    }

    //prompt user for verb and nouns
    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

<<<<<<< Updated upstream
//    private void startCommand(List<String> choice){
//
//        for(int i = 0; i < choice.size(); i++){
//            String verb = choice.get(0);
//            String noun = choice.get(1);
//        }
//
//        if ("go".equals(verb)) {
//            move(noun);
//        } else {
//            System.out.println("testing");
//        }
//
//    }

=======
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    //loads the location from location.json(parsing it)
    private void loadsLocation() {
=======
>>>>>>> Stashed changes
    //parses the location
    public void generateWorld () {
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream

        //initialize Characters to utilize attributes
        Character.NPC1 npc1 = character.getNpc1();
        Character.NPC2 npc2 = character.getNpc2();
        Character.NPC3 npc3 = character.getNpc3();
        Character.NPC4 npc4 = character.getNpc4();
        Character.NPC5 npc5 = character.getNpc5();

        System.out.printf("\n\n%s, You are located at: %s \nitems: %s \ndirections: %s\n",
                player.getName(), currentLocation, items, directions);

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
=======
        System.out.printf("\n\n%s, you are located at: %s \nitems: %s \ndirections: %s\n",
                player.getName(), currentLocation, item, directions);
>>>>>>> Stashed changes
    }
}


