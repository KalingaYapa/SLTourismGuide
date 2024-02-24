package com.project.sltourguide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    private int counter;
    @GetMapping
    public String demo() {
        counter++;
        return String.format("<h1>Response from Tour Guider , Response Number %d</h1>",counter);
    }
}
