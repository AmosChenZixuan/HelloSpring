package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

public class App03GamingSpringBeans {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GamingConfig.class)) {
            var gameRunner = context.getBean(GameRunner.class);
            gameRunner.run();
        }
    }
}
