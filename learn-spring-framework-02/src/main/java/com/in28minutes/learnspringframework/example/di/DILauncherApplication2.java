package com.in28minutes.learnspringframework.example.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan
public class DILauncherApplication2 {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DILauncherApplication2.class)) {
            BusinessCalculationService businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.findMax());
        }
    }

}

interface DataService {
    int[] retrieveData();
}

@Component
@Primary
class MongoDB implements DataService {
    public int[] retrieveData() {
        return new int[] { 5, 89, 100 };
    }
}

@Component
class MySQL implements DataService {
    public int[] retrieveData() {
        return new int[] { 1, 2, 3 };
    }
}

@Component
class BusinessCalculationService {
    DataService dataService;

    public BusinessCalculationService(@Qualifier("mySQL") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}