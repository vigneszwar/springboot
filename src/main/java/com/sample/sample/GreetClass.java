package com.sample.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GreetClass {


    public ArrayList<Integer> numbers;

    public GreetClass() {
        System.out.println("Inside Greet Class Constructor");
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
    public String greet(String name) {
        return "Hello " + name;
    }


}
