package com.virusbuster.controller;

import com.virusbuster.model.GameMap;
import com.virusbuster.view.View;

public class Controller {

    private View view;
    private GameMap map;

    public Controller(){
    }

    public Controller(View view, GameMap map){
        super();
        this.view = view;
        this.map = map;
    }

    public void startGame(){
        View.welcome();
        View.gameInstructions();
    }

    public void createMap(){
        System.out.println(map.displayLocation());
    }

    public String userInput() {
        return View.promptForPlayorQuit();
    }

    public void loserMessage(){
        View.loserMessage();
    }


}

