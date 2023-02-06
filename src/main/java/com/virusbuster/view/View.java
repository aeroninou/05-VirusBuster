package com.virusbuster.view;

import com.apps.util.Prompter;
import com.apps.util.Console;
import com.virusbuster.model.Game;

import java.io.*;
import java.util.*;

public class View {

    private static final String WINNER_TEXT = "ascii/winner.txt";
    private static final String TITLE_BANNER = "ascii/welcome.txt";
    private static final String GAME_INSTRUCTIONS = "ascii/gameinstruction.txt";
    private static final String EXIT_MESSAGE = "ascii/exitmessage.txt";
    private static final String GAME_COMMANDS = "ascii/commandshelp.txt";
    private static final String EMPTY_MAP = "mapImages/emptyMap.txt";
    private static final String AREA51_MAP = "mapImages/area51Room.txt";
    private static final String LABORATORY_MAP = "mapImages/labMap.txt";
    private static final String PORTAL_ROOM_MAP = "mapImages/portalRoom.txt";
    private static final String ARMORY_MAP = "mapImages/armoryRoom.txt";
    private static final String CAFETERIA_MAP = "mapImages/cafeteriaRoom.txt";
    private static final String AMAZON_JUNGLE_MAP = "mapImages/amazonJungleRoom.txt";
    private static final String DUBAI_MAP = "mapImages/dubaiRoom.txt";
    private static final String UZBEKIZTAN_MAP = "mapImages/uzbekiRoom.txt";
    private static final String GREENLAND_MAP = "mapImages/greenlandRoom.txt";
    private static final Prompter prompter = new Prompter(new Scanner(System.in));

    //const for all string literals.
    private static final String READY_PROMPT = "\nAre you ready to rescue the world?";
    private static final String ENTER_P_PLAY_OR_Q_QUIT_PROMPT_MESSAGE = "\nEnter 'P'/Play or 'Q'/Quit?: ";
    private static final String REGEX_FOR_PLAY_OR_QUIT_PROMPT = "(?i)(P|Q|PLAY|QUIT)";
    private static final String ERROR_MESSAGE_FOR_PLAY_OR_QUIT_PROMPT = "Error...must be letter P, PLAY, Q, or QUIT";
    private static final String PRESS_ENTER_TO_CONTINUE_PROMPT_MESSAGE = "\nPress \"ENTER\" to continue...";
    public static final String SAVE = "\nWould you like to save? Press Y|YES or N|No\n";
    public static final String YES_NO = "(?i)(Y|N|YES|NO)";
    public static final String INVALID_INPUT = "\nInvalid Input";
    public static final String CONTINUE_PREVIOUS_GAME_PRESS_Y_YES_OR_N_NO = "\nWould you like to continue previous game? Press Y|YES or N|No\n";

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
        System.exit(0);
    }

    //prints winner message.
    public void winner() {
        Console.clear();
        textLoader(WINNER_TEXT);
        System.exit(0);
    }

    //prints out game instructions
    public void gameInstructions() {
        textLoader(GAME_INSTRUCTIONS);
        promptEnterKey();
        Console.clear();
    }

    public void gameOverMessage() {
        textLoader(EXIT_MESSAGE);
    }

    //prints out the verbs/nouns
    public void commandsHelp() {
        Console.clear();
        textLoader(GAME_COMMANDS);
        promptEnterKey();
    }

    //display map for the user on "map"
    public void displayEmptyMap() {
        Console.clear();
        textLoader(EMPTY_MAP);
    }

    //TODO: Create a MAP class and map json file for ticket 178
    //display map based on user current location

    public void displayArea51Map() {
        textLoader(AREA51_MAP);
    }

    public void displayPortalRoomMap() {
        textLoader(PORTAL_ROOM_MAP);
    }

    public void displayLabMap() {
        textLoader(LABORATORY_MAP);
    }

    public void displayArmoryMap() {
        textLoader(ARMORY_MAP);
    }

    public void displayCafeMap() {
        textLoader(CAFETERIA_MAP);
    }

    public void displayAmazonJungleMap() {
        textLoader(AMAZON_JUNGLE_MAP);
    }

    public void displayDubaiMap() {
        textLoader(DUBAI_MAP);
    }

    public void displayUzbekiMap() {
        textLoader(UZBEKIZTAN_MAP);
    }

    public void displayGreenlandMap() {
        textLoader(GREENLAND_MAP);
    }


    //loads the text files
    public void textLoader(String filepath) {
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
            game.checkPlayer();
        } else if ("Q".equals(answer) || "QUIT".equals(answer)) {
            gameOverMessage();
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
