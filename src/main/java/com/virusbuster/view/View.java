package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {
    //welcome the player with a title/splash screen
    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "src/main/resources/ascii/gameinstruction.txt";
    private static final String LOSER_MESSAGE = "src/main/resources/ascii/losermessage.txt";
    private static String banner;

    private static Prompter prompter = new Prompter(new Scanner(System.in));

    private enum Option {
        PLAY,
        QUIT
    }

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
                Console.pause(50);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        Console.clear();
    }

    public static Option promptForPlayorQuit() {
        Console.clear();
        String answer = prompt("Enter 'P' for Play or 'Q' for Quit?: ", "(?i)(P|Q)", "Error... ").toUpperCase();

        Option option = null;
        if ("P".equals(answer)) {
//            option = Option.PLAY;
            System.out.println("Play");
        } else if ("Q".equals(answer)) {
            System.out.println("Quit");
//            option = Option.QUIT;
        }
        return option;
    }

    private static String prompt(String promptMessage, String regex, String helpMessage) {

        try {
            String answer = prompter.prompt(promptMessage, regex, helpMessage).toUpperCase();
            return answer;
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }
}
