package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloSpring {
    public static void main(String[] args) {
        // launch a spring context
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class)) {
            // configure stuff that spring will manage - @Configuration
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("myaddress"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person2"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
        
    }
}
