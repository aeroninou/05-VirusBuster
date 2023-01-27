package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import com.virusbuster.model.Game;
import com.virusbuster.model.GameMap;
import com.virusbuster.model.Item;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {
    //welcome the player with a title/splash screen
    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "src/main/resources/ascii/gameinstruction.txt";
    private static final String LOSER_MESSAGE = "src/main/resources/ascii/losermessage.txt";
    private static final String GAME_COMMANDS = "src/main/resources/ascii/commandshelp.txt";
    private static String banner;

    private static Prompter prompter = new Prompter(new Scanner(System.in));

    public static void welcome() {
        Console.clear();
        try {
         banner = Files.readString(Path.of(TITLE_BANNER));
            System.out.println(banner);
        } catch (IOException e){
            e.printStackTrace();
        }
        Console.pause(3000);
        Console.clear();
    }

    public static void displayLocation(Game game){
        String currentLocation = game.getCurrentLocation().getName();
        List<String> items = game.getCurrentLocation().getItems();
        HashMap<String,String> directions = game.getCurrentLocation().getDirections();
        System.out.printf("\nYou are located at: %s \nitems: %s \ndirections: %s",
                currentLocation,items,directions);
    }

    public static void loserMessage() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(LOSER_MESSAGE));
            System.out.println(banner);
        } catch (IOException e){
            e.printStackTrace();
        }
        Console.pause(3000);
        Console.clear();
    }

    public static void gameInstructions() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(GAME_INSTRUCTIONS));
            for (char ch : banner.toCharArray()){
                System.out.print(ch);
                Console.pause(10);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        Console.clear();
    }

    //prints out the verbs/nouns
    public static void commandsHelp() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(GAME_COMMANDS));
            System.out.println(banner);
        } catch (IOException e){
            e.printStackTrace();
        }
        Console.pause(1000);
        Console.clear();
    }


    public static void promptForPlayorQuit() {
        Console.clear();
        System.out.println("\nAre you ready to rescue the world?");
        String answer = prompt("\nEnter 'P' for Play or 'Q' for Quit?: ", "(?i)(P|Q)", "Error... ").toUpperCase();

        if ("P".equals(answer)) {
            commandsHelp();
            Game.gameTest();
        } else if ("Q".equals(answer)) {
            loserMessage();
        }
    }

    private static String prompt(String promptMessage, String regex, String helpMessage) {

        try {
            return prompter.prompt(promptMessage, regex, helpMessage).toUpperCase();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }

}
