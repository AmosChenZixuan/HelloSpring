package com.in28minutes.learnspringframework.example.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* Java Singleton: one instance per JVM
 * Spring Singleton: one instance per IoC container   (for stateful beans)
 * Spring Prototype: multiple instances per IoC container (for stateless beans)
 * ----- Specifically applicable to web-aware applications -----
 * Request: one instance per request
 * Session: one instance per session
 * Application: one instance per application runtime
 * Websocket: one instance per websocket instance
 * 
 */

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)) {
            System.out.println(context.getBean(ClassA.class));
            System.out.println(context.getBean(ClassA.class));

            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassB.class));
        }
    }

}

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // singleton by default
class ClassA {

}

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ClassB {

}