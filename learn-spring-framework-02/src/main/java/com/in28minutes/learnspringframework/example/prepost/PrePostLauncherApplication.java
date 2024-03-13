package com.in28minutes.learnspringframework.example.prepost;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Configuration
@ComponentScan
public class PrePostLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(PrePostLauncherApplication.class)) {
            System.out.println(context.getBean(Service.class));
        }
    }

}

@Component
class Resource {
    public void load(){
        System.out.println("Resource loaded");
    }

    public void unload(){
        System.out.println("Resource unloaded");
    }
}

@Component
class Service {
    Resource resource;

    Service(Resource res ) {
        resource = res;
        System.out.println("Service Constructed");
    }

    @PostConstruct
    private void init() {
       resource.load();
    }

    @PreDestroy
    private void cleanup() {
        resource.unload();
    }
}