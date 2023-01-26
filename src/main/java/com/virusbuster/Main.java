package com.virusbuster;

import com.virusbuster.controller.Controller;
import com.virusbuster.model.Game;
import com.virusbuster.model.GameMap;
import com.virusbuster.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        GameMap map = new GameMap();
        Game game = new Game();
        Controller controller = new Controller(view,map, game);

        controller.userInput();

    }

}
