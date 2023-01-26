package com.virusbuster.model;

import java.util.Scanner;

public class Game {

    private static Commands move;


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

}