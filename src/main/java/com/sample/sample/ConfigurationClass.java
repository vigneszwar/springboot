package com.sample.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
//new line
@Configuration
public class ConfigurationClass {
    @Bean
    public ArrayList<Integer> getNumbers() {
        System.out.println("Creating ArrayList Numbers object");
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(4);
        return objects;
    }
}
