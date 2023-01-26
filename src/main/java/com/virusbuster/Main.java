package com.virusbuster;

import com.virusbuster.controller.Controller;
import com.virusbuster.model.Game;
import com.virusbuster.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        //Display Game Title
        //Game Summary
        //controller.startGame();

//        String userInput = controller.userInput();
//
//        //user input and play game or quit game.
//        //also to play the game again.
//        if("P".equals(userInput)){
//            controller.startGame();
//        } else{
//            controller.loserMessage();
//        }


        Game.gameTest();

    }

}
