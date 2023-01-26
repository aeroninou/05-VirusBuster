package com.virusbuster.model;

import java.util.Scanner;

import static com.virusbuster.view.View.*;

public class Game {

    private static Commands move;

    private void startGame() {
        welcome();
        gameInstructions();

    }

    public static void gameTest (){
        boolean inputVaild = false;
        while (!inputVaild){
            System.out.println('>');
            String [] moveInput = commandInput().toLowerCase().split(" ");

            if ("look".equals(moveInput[0])){
                move = validCommand(moveInput[0]);
                System.out.println("You input was " + moveInput[0]);
                inputVaild = true;

            } else if ("bag".equals(moveInput[0])){
                move = validCommand(moveInput[0]);
                System.out.println("You chose " + move);
                inputVaild = true;
            }
        }
    }


    private static Commands validCommand(String input) {
        Commands result = null;
        for (Commands command : values()) {
            if (command.getValue().equalsIgnoreCase(input)) {
                result = command;
                break;
            }
        }
        return result;
    }

    private static Commands[] values() {
        return Commands.values();
    }

    private static String commandInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        return input;
    }

    // Players enter a Verb and Noun to interact with the world
    private static void userCommand(){
        System.out.println("What would you like to do? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String arr[] = input.toLowerCase().split("[ \t,.:;?!\"']+", 2);

        String move = arr[0];
        String item = arr[1];
        System.out.println(move);
        if (move.equals("go")){
            //function for go
            System.out.println(move);

        }else if(move.equals("look")){
            System.out.println("not working");
            //function for look
        }

    }
}

