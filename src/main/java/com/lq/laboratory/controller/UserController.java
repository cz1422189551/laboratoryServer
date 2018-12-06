package com.lq.laboratory.controller;

import com.google.gson.Gson;
import com.lq.laboratory.entity.*;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import static com.lq.laboratory.util.Const.STUDENT;

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

        User user = userService.getUserByUserNameAndPassword(userName, password);
        return EntityFactory.createResponse(user);
    }


    @RequestMapping("/list/{pageNumber}/{pageSize}")
    public ResponseEntity list(@PathVariable("pageNumber") int pageNumber
            , @PathVariable("pageSize") int pageSize) {

        Result<User> list = userService.getList(pageNumber, pageSize);
        return EntityFactory.createResponse(list);
    }

    @RequestMapping("/getList")
    public ResponseEntity getList(int pageNum, int pageSize) {
        Result<User> list = userService.getList(pageNum, pageSize);
        return EntityFactory.createResponse(list);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody User user) {

        for (int i = 0; i < 50; i++) {
            User u = new Student(i + 1, "admin" + (i + 1), "admin" + (i + 1), "狮子吃咸鱼" + i, "18807772672", 1%2, STUDENT, new Date(), "广州", "计科本", "电信学院");
            EntityFactory.createResponse(userService.insert(u));
        }
        return EntityFactory.createResponse(userService.insert(user));

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(String fsFormData ) throws UnsupportedEncodingException {
//        String tmp = URLDecoder.decode(fsFormData, "UTF-8");
        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
//        User user1 = new Student(99, "admin", "admin", "测试", "13197670831", true, STUDENT, new Date(), "钦州", "毕业", "研发部");
        return EntityFactory.createResponse(userService.update(u));

    }


    @RequestMapping()
    public ModelAndView page() {
        return new ModelAndView("user");
    }

    @RequestMapping("/add/page")
    public ModelAndView addPage() {
        return new ModelAndView("add_user");
    }
}
