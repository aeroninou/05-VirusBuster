package com.virusbuster.controller;

import com.virusbuster.model.Game;
import com.virusbuster.model.GameMap;
import com.virusbuster.view.View;

public class Controller {

    private View view;
    private GameMap map;
    private Game game;

    public Controller(View view, GameMap map, Game game){
        super();
        this.view = view;
        this.map = map;
        this.game = game;
    }

    public void userInput() {
        View.welcome();
        View.gameInstructions();
        View.commandsHelp();
        View.promptForPlayorQuit();
    }
}

