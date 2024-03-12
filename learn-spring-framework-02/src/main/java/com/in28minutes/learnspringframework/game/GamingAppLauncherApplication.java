package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            var gameRunner = context.getBean(GameRunner.class);
            gameRunner.run();
        }
    }

    // @Bean
    // public iGame gameConsole() {
    //     return new MarioGame();
    // }

    // @Bean
    // public GameRunner gameRunner(iGame gameConsole) {
    //     return new GameRunner(gameConsole);
    // }
}
