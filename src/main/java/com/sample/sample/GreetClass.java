package com.sample.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


// component for greet class
@Component
public class GreetClass {


    //  a new branch is created
    @Autowired
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
