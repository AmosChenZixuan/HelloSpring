package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var SuperContraGame = new SuperContraGame();
        var packmanGame = new PacmanGame();
        var gameRunner = new GameRunner(packmanGame);
        gameRunner.run();
    }
}
