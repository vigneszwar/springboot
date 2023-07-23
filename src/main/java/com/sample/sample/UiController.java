package com.sample.sample;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    @GetMapping("/welcome")
    public String greeting(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        System.out.println(userDetails.getUsername());
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}