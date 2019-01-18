package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.lq.laboratory.util.Const.ADMIN;

@RestController
public class LoginController {

    @Autowired
    UserServiceImpl service;


    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    public User appLogin(String userName, String password) {
        return login(userName, password);
    }

    @RequestMapping(value = "/web/login", method = RequestMethod.POST)
    public ResponseEntity webLogin(@RequestBody User user) {
        User login = login(user.getUserName(), user.getPassword());
        if (login == null || login.getUserType() != ADMIN) throw new RuntimeException("管理员账号或密码错误");
        return EntityFactory.createResponse(login);
    }

    private User login(String userName, String password) {
        User userInfo = service.getUserByUserNameAndPassword(userName, password);
        return userInfo;
    }

}
