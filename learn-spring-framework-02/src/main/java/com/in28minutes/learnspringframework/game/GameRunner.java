package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    iGame game;

    public GameRunner(@Qualifier("superContraGame") iGame game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running the game " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }

}
