package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.iGame;

@Configuration
public class GamingConfig {

    @Bean
    public iGame gameConsole() {
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(iGame gameConsole) {
        return new GameRunner(gameConsole);
    }
}
