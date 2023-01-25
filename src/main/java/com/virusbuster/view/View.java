package com.virusbuster.view;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class View {
    //welcome the player with a title/splash screen
    private static final String TITLE_BANNER = "src/main/resources/ascii/welcome.txt";
    private static String banner;

    public static void welcome() {
        try {
         banner = Files.readString(Path.of(TITLE_BANNER));
            System.out.println(banner);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
