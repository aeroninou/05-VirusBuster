package com.virusbuster;

import com.virusbuster.controller.Controller;
import com.virusbuster.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        //Display Game Title
        controller.displayGameTitle();

        //print out Game Summary
        controller.gameInstruction();

        //play and quit
        controller.userInput();
    }

}
