package com.virusbuster.model;

import com.google.gson.Gson;
import com.virusbuster.view.View;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import static com.virusbuster.view.View.*;

public class Game {

    private static String verb;
    private static GameMap.LocationLayout currentLocation;
    private static String noun;
    private static View view;
    public static GameMap gameWorld;
    public static Player player = new Player();

    public Game() {
    }

    //private static final String startingLocation = "Area51";
    private static List<String> items = new ArrayList<>(Arrays.asList("CAMU CAMU", "CAMEL MILK", "SUMALAK", "RAINCOAT", "GLACIER MAGICAL PLANT"));
    private static List<String> commands = new ArrayList<>(Arrays.asList("GO", "GET", "ENTER", "TRADE", "TALK", "BAG"));


    public static void parseCommand(List<String> wordlist) {

        if (wordlist.size() != 2) {
            System.out.println("Error! Enter 2 words for command");
        } else {
            verb = String.valueOf(validCommand(wordlist.get(0)));
            noun = wordlist.get(1);

            if (!commands.contains(verb)) {
                System.out.println(verb + " is not a verb");
            }
            if (!items.contains(noun)) {
                System.out.println(noun + " is not a noun!");
            }
        }
    }

    public static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims, 2);

        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }

    public static String runCommand(String inputstr) {
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

    public static void gameTest () {

        player.setName(Player.promptForName());

        displayLocation(player);
        boolean inputVaild = false;
        while (!inputVaild) {
            System.out.println('↓');
            String moveInput = commandInput();
            runCommand(moveInput);

            if ("go".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("get".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("enter".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("trade".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("talk".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("look".equalsIgnoreCase(String.valueOf(verb))) {
                inputVaild = isValid(noun);

            } else if ("help".equalsIgnoreCase(String.valueOf(verb))) {
                commandsHelp();
            } else if ("quit".equalsIgnoreCase(String.valueOf(verb))) {
                exitMessage();
                System.exit(0);
            }
        }
    }

    private static Commands validCommand (String input){
        Commands result = null;
        for (Commands command : values()) {
            if (command.getValue().equalsIgnoreCase(input)) {
                result = command;
                break;
            }
        }
        return result;
    }

    private static boolean isValid (String input){
        if (items.contains(input)) {
            System.out.printf("Your input was [%s, %s]", verb, noun);
            return true;
        } else {
            System.out.printf("Sorry, [%s, %s] is not a valid. See below for valid inputs.", verb, noun);
            commandsHelp();
            return false;
        }
    }


    private static Commands[] values () {
        return Commands.values();
    }

    private static String commandInput () {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    //parses the location
    public void generateWorld () {
        try (Reader reader = new FileReader("src/main/resources/data/location.json")) {
            gameWorld = new Gson().fromJson(reader, GameMap.class);
            player.setCurrentLocation(gameWorld.getArea51());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayLocation (Player player){
        String currentLocation = player.getCurrentLocation().getName();
        List<String> items = player.getCurrentLocation().getItems();
        HashMap<String, String> directions = player.getCurrentLocation().getDirections();
        System.out.printf("\n\n%s, you are located at: %s \nitems: %s \ndirections: %s\n",
                player.getName(), currentLocation, items, directions);
    }
}


