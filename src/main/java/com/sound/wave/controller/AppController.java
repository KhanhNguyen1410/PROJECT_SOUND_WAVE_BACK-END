package com.sound.wave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to Soundwave !!!";
    }
}
