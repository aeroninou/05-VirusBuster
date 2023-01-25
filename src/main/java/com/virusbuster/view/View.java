package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class View {
    //welcome the player with a title/splash screen
    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "src/main/resources/ascii/gameinstruction.txt";

    public enum Option {
        PLAY,
        QUIT
    }

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
        Console.clear();
    }

    public static void gameInstructions() {
        Console.clear();
        try {
            banner = Files.readString(Path.of(GAME_INSTRUCTIONS));
            for (char ch : banner.toCharArray()){
                System.out.print(ch);
                Thread.sleep(50);
            }

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        Console.clear();
    }

    public static Option promptForOption() {
        Console.clear();
        System.out.println(" ");
        String answer = prompter.prompt("Enter P to play and Q to quit: ").toUpperCase();

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
}
