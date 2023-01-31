package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import com.virusbuster.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {

    private static final String TITLE_BANNER = "ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "ascii/gameinstruction.txt";
    private static final String EXIT_MESSAGE = "ascii/exitmessage.txt";
    private static final String GAME_COMMANDS = "ascii/commandshelp.txt";
    private static final Prompter prompter = new Prompter(new Scanner(System.in));
    private Game game = new Game();



    //welcome the player with a title/splash screen
    public  void welcome() {
        Console.clear();
        //noinspection ConstantConditions
        try (InputStream inputStream  = View.class.getClassLoader().getResourceAsStream(TITLE_BANNER);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ){
            for(String line = reader.readLine(); line!=null; line = reader.readLine()){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Console.pause(3000);
        promptEnterKey();
        Console.clear();
    }

    //print exit message on quit
    public  void exitMessage() {
        Console.clear();
        //noinspection ConstantConditions
        try (InputStream inputStream  = View.class.getClassLoader().getResourceAsStream(EXIT_MESSAGE);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ){
            for(String line = reader.readLine(); line!=null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.pause(3000);
        Console.clear();
    }

    //prints out game instructions
    public void gameInstructions() {
        //noinspection ConstantConditions
        try (InputStream inputStream  = View.class.getClassLoader().getResourceAsStream(GAME_INSTRUCTIONS);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ){
            for(String line = reader.readLine(); line!=null; line = reader.readLine()){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        promptEnterKey();
        Console.clear();
    }

    //prints out the verbs/nouns
    public void commandsHelp() {
        Console.clear();
        //noinspection ConstantConditions
        try (InputStream inputStream  = View.class.getClassLoader().getResourceAsStream(GAME_COMMANDS);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ){
            for(String line = reader.readLine(); line!=null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        promptEnterKey();
        Console.clear();
    }

    //asking player if they want to play game or quit. will execute
    public void promptForPlayorQuit() {
        System.out.println("\nAre you ready to rescue the world?");
        String answer = prompt("\nEnter 'P'/Play or 'Q'/Quit?: ", "(?i)(P|Q|PLAY|QUIT)", "Error...must be letter P, PLAY, Q, or QUIT").toUpperCase();

        if ("P".equals(answer) || "PLAY".equals(answer)) {
            commandsHelp();
            game.gameTest();
        } else if ("Q".equals(answer) || "QUIT".equals(answer)) {
            exitMessage();
        }
    }

    //create a prompt method to uses for error checking
    public String prompt(String promptMessage, String regex, String helpMessage) {

        try {
            return prompter.prompt(promptMessage, regex, helpMessage).toUpperCase();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }

    //will pause until Enter is pressed.
    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
