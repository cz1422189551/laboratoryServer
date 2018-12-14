package com.lq.laboratory.controller;

import com.lq.laboratory.entity.User;
import com.lq.laboratory.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserServiceImpl service;


    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    public User appLogin(String userName, String password) {
        User userInfo = service.getUserByUserNameAndPassword(userName, password);
        return userInfo;
    }

}
