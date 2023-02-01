package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import com.virusbuster.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {

    private static final String TITLE_BANNER = "ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "ascii/gameinstruction.txt";
    private static final String EXIT_MESSAGE = "ascii/exitmessage.txt";
    private static final String GAME_COMMANDS = "ascii/commandshelp.txt";
    private static final Prompter prompter = new Prompter(new Scanner(System.in));

    //const for all string literals.
    private static final String READY_PROMPT = "\nAre you ready to rescue the world?";
    private static final String ENTER_P_PLAY_OR_Q_QUIT_PROMPT_MESSAGE = "\nEnter 'P'/Play or 'Q'/Quit?: ";
    private static final String REGEX_FOR_PLAY_OR_QUIT_PROMPT = "(?i)(P|Q|PLAY|QUIT)";
    private static final String ERROR_MESSAGE_FOR_PLAY_OR_QUIT_PROMPT = "Error...must be letter P, PLAY, Q, or QUIT";
    private static final String PRESS_ENTER_TO_CONTINUE_PROMPT_MESSAGE = "Press \"ENTER\" to continue...";

    private final Game game = new Game(this);


    //welcome the player with a title/splash screen
    public void welcome() {
        Console.clear();
        textLoader(TITLE_BANNER);
        Console.pause(4000);
        Console.clear();
    }

    //print exit message on quit
    public void exitMessage() {
        Console.clear();
        textLoader(EXIT_MESSAGE);
        Console.pause(3000);
        Console.clear();
    }

    //prints out game instructions
    public void gameInstructions() {
        textLoader(GAME_INSTRUCTIONS);
        promptEnterKey();
        Console.clear();
    }

    //prints out the verbs/nouns
    public void commandsHelp() {
        Console.clear();
        textLoader(GAME_COMMANDS);
        promptEnterKey();
    }

    //loads the text files
    private void textLoader(String filepath) {
        //noinspection ConstantConditions
        try (InputStream inputStream = View.class.getClassLoader().getResourceAsStream(filepath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //asking player if they want to play game or quit. will execute
    public void promptForPlayOrQuit() {
        System.out.println(READY_PROMPT);
        String answer = prompt(ENTER_P_PLAY_OR_Q_QUIT_PROMPT_MESSAGE, REGEX_FOR_PLAY_OR_QUIT_PROMPT, ERROR_MESSAGE_FOR_PLAY_OR_QUIT_PROMPT).toUpperCase();

        if ("P".equals(answer) || "PLAY".equals(answer)) {
            commandsHelp();
            game.startGame();
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
    public void promptEnterKey() {
        System.out.println(PRESS_ENTER_TO_CONTINUE_PROMPT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
