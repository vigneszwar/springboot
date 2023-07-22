package com.sample.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ConfigurationClass {
    @Bean
    //getNumber is a function to get a function
    public ArrayList<Integer> getNumbers() {
        System.out.println("Creating ArrayList Numbers object");
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(4);
        return objects;
    }
}
