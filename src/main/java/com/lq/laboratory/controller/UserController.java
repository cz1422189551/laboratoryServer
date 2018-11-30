package com.lq.laboratory.controller;

import com.lq.laboratory.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "user", method = RequestMethod.GET,produces = "application/json")
    public User getUser() {
        User user = new User("admin", "admin");
        return user;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("username","admin");
        User user = new User("admin", "admin");
        return "login";
    }


}
