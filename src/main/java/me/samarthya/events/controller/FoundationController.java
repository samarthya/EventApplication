package me.samarthya.events.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundationController {

    @ResponseBody
    @GetMapping(path = "/hello")
    String sayHello() {
        return "Hello Application!";
    }
}
