package com.virusbuster.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class View {
    //welcome the player with a title/splash screen
    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "src/main/resources/ascii/gameinstruction.txt";

    private static String banner;

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
}
