package com.sample.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    GreetClass greetClass;

    @Autowired
    public HelloController(GreetClass greetClass) {
        this.greetClass = greetClass;
    }

    @GetMapping
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok().body(greetClass.getNumbers().toString());
    }

}
