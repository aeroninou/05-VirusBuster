package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import com.virusbuster.model.Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {

    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "src/main/resources/ascii/gameinstruction.txt";
    private static final String EXIT_MESSAGE = "src/main/resources/ascii/exitmessage.txt";
    private static final String GAME_COMMANDS = "src/main/resources/ascii/commandshelp.txt";
    private static final Prompter prompter = new Prompter(new Scanner(System.in));
    private static String banner;


    //welcome the player with a title/splash screen
    public static void welcome() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(TITLE_BANNER));
            System.out.println(banner);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.pause(3000);
        Console.clear();
    }

    //print exit message on quit
    public static void exitMessage() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(EXIT_MESSAGE));
            System.out.println(banner);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.pause(3000);
        Console.clear();
    }

    //prints out game instructions
    public void gameInstructions() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(GAME_INSTRUCTIONS));
            for (char ch : banner.toCharArray()) {
                System.out.print(ch);
                Console.pause(10);
            }

        } catch (IOException e) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.pause(1000);
        Console.clear();
    }


    //asking player if they want to play game or quit. will execute
    public void promptForPlayorQuit() {
        Console.clear();
        System.out.println("\nAre you ready to rescue the world?");
        String answer = prompt("\nEnter 'P'/Play or 'Q'/Quit?: ", "(?i)(P|Q|PLAY|QUIT)", "Error...must be letter P, PLAY, Q, or QUIT").toUpperCase();

        if ("P".equals(answer) || "PLAY".equals(answer)) {
            commandsHelp();
            Game.gameTest();
        } else if ("Q".equals(answer) || "QUIT".equals(answer)) {
            exitMessage();
        }
    }

    //create a prompt method to uses for error checking
    public static String prompt(String promptMessage, String regex, String helpMessage) {

        try {
            return prompter.prompt(promptMessage, regex, helpMessage).toUpperCase();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }

}
