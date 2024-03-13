package com.in28minutes.learnspringframework.example.xmlconfig;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

public class XMLConfigLauncherApplication {

    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("contextConfig.xml")) {
            Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
            
            System.out.println(context.getBean("name"));

            context.getBean(GameRunner.class).run();
        }
    }

}
