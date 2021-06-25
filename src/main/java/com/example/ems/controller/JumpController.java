package com.example.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping(value={"/msgsearch.html", "/toMsgsearch"})
    public String jumpToMsgsearch() {
        return "msgsearch.html";
    }
}
