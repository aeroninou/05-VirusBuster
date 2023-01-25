package com.virusbuster.controller;

import com.virusbuster.view.View;

public class Controller {

    private View view;

    public Controller(){
    }

    public Controller(View view){
        super();
        this.view = view;
    }

    public void displayGameTitle(){
        View.welcome();
    }

    public void gameInstruction(){
        View.gameInstructions();
    }

    public static void userInput  () {
        View.promptForOption();
    }


}

