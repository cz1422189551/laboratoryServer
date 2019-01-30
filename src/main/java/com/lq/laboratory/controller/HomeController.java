package com.lq.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //首页
    @RequestMapping("/")
    public String home() {
        System.out.println("home");
        return "index.html";
    }

}
