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

    public void startGame(){
        View.welcome();
        View.gameInstructions();
    }

    public String userInput() {
        return View.promptForPlayorQuit();
    }

    public void loserMessage(){
        View.loserMessage();
    }


}

