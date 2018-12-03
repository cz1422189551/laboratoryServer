package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.services.IService;
import com.lq.laboratory.services.UserService;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static com.lq.laboratory.services.Const.STUDENT;
import static com.lq.laboratory.services.Const.TEACHER;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/one/{id}")
    public ResponseEntity getOne(@PathVariable("id") String id) {

        User user = userService.getOne(id);
        return EntityFactory.createResponse(user);
    }


    @RequestMapping("/{userName}/{password}")
    public ResponseEntity getOneByUserNameAndPassword(@PathVariable("userName") String userName, @PathVariable("password") String password) {

        User user = userService.getUserByUserNameAndPassword(userName,password);
        return EntityFactory.createResponse(user);
    }


    @RequestMapping("/list/{pageNumber}/{pageSize}")
    public ResponseEntity getList(@PathVariable("pageNumber") int pageNumber
            , @PathVariable("pageSize") int pageSize) {

        Result<User> list = userService.getList(pageNumber, pageSize);
        return EntityFactory.createResponse(list);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody User user) {
        return EntityFactory.createResponse(userService.insert(user));

    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ResponseEntity update(User user) {
        User user1 = new Student(99, "admin", "admin", "测试", "13197670831", true, STUDENT, new Date(), "钦州", "毕业", "研发部");
        return EntityFactory.createResponse(userService.update(user1));

    }


    @RequestMapping()
    public ModelAndView page() {
        return new ModelAndView("user");
    }
}
