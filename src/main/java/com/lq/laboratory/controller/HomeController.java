package com.lq.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("index")
    public String home() {
        System.out.println();
        return "index";
    }
}
