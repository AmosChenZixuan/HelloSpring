package com.in28minutes.learnspringframework.example.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan  // default is current package; "package com.in28minutes.learnspringframework.example.di;"
public class DILauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DILauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(Business.class));
        }

        
    }

}

@Component
class Business {
    // Field Injection
    // @Autowired 
    Dependency1 dependency1;
    Dependency2 dependency2;

    // Setter Injection
    // @Autowired 
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection");
        this.dependency2 = dependency2;
    }

    // Constructor Injection  #Recommended!
    // @Autowired       // Optional for readability, is automatically added by Spring.
    public Business(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Business [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
    }
}

@Component
class Dependency1 {
    public String toString() {
        return "Dependency1 []";
    }
}

@Component
class Dependency2 {
    public String toString() {
        return "Dependency2 []";
    }
}