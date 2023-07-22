package com.sample.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ConfigurationClass {
    @Bean
    public ArrayList<Integer> getNumbers() {
        System.out.println("Creating ArrayList Numbers object");
        ArrayList<Integer> object = new ArrayList<>();
        object.add(1);
        object.add(2);
        object.add(4);
        return object;
    }
}
