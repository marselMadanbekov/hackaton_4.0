package com.example.hackaton_4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class StatisticsController {
    @GetMapping("")
    public String news(){
        return "user/general-analytics";
    }
}
