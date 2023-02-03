package com.virusbuster.controller;

//import com.virusbuster.model.GameMap;
import com.virusbuster.model.Game;
import com.virusbuster.view.View;

public class Controller {

    private final View view;
    //private GameMap map;
    private final Game game;

    public Controller(View view, Game game){
        super();
        this.view = view;
        //this.map = map;
        this.game = game;
    }

    //starts the flow of game.
    public void userInput() {
        view.welcome();
        view.gameInstructions();
        //game.generateWorld();
        view.promptForPlayOrQuit();

    }
}

