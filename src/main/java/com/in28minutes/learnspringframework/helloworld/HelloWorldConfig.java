package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {};

record Address (String street, String city) {};

@Configuration
public class HelloWorldConfig {
    @Bean
    public String name() {
        return "Amos";
    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    public Person person() {
        return new Person("Chen", age(), address());
    }

    @Bean(name = "myaddress")
    public Address address() {
        return new Address("1234 Main St", "San Francisco");
    }

    @Bean
    public Person person2(String name) {
        return new Person(name, age(), address());
    }
}
