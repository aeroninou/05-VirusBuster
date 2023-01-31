package com.virusbuster;

import com.virusbuster.controller.Controller;
import com.virusbuster.model.Game;
//import com.virusbuster.model.GameMap;
import com.virusbuster.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        //GameMap map = new GameMap();
        Game game = new Game(view);
        Controller controller = new Controller(view, game);

        //calling controller input asking for play or quit.
        controller.userInput();
    }


}
