package com.in28minutes.learnspringframework.example.lazyinit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan
public class LazyInitLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyInitLauncherApplication.class)) {
            context.getBean(ClassA.class);
        }
    }

}

@Component
@Lazy(false)
class ClassA {
    ClassA () {
        System.out.println("ClassA is initialized");
    }
}

@Component
@Lazy
class ClassB {
    ClassB () {
        System.out.println("ClassB is initialized");
    }
}