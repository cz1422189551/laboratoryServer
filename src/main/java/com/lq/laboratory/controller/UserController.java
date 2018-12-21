package com.lq.laboratory.controller;


import com.lq.laboratory.entity.*;
import com.lq.laboratory.exception.UserExpcetion;
import com.lq.laboratory.repository.specifi.UserSpecification;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import com.lq.laboratory.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.Const.TEACHER;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

//    @RequestMapping("/one/{id}")
//    public ResponseEntity getOne(@PathVariable("id") String id) {
//
//        User user = userService.getOne(id);
//        return EntityFactory.createResponse(user);
//    }

    @RequestMapping("/one")
    public ResponseEntity getOne(@RequestParam(name = "funcId") String id) {
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
    public ResponseEntity getList(@RequestParam Map<String, String> map) {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = userService.getList(UserSpecification.<User>findByAnd(map), pageNum, pageSize);

        return EntityFactory.createResponse(EntityFactory.createResult(page));
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(String fsFormData) {
        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
//        for (int i = 0; i < 50; i++) {
//            User u = new Student(i + 1, "admin" + (i + 1), "admin" + (i + 1), "狮子吃咸鱼" + i, "18807772672", 1 % 2, STUDENT, new Date(), "广州", "计科本", "电信学院");
//            EntityFactory.createResponse(userService.insert(u));
//        }
        return EntityFactory.createResponse(userService.insert(u));

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(String fsFormData) throws UnsupportedEncodingException {
//        String tmp = URLDecoder.decode(fsFormData, "UTF-8");
        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
//        User user1 = new Student(99, "admin", "admin", "测试", "13197670831", true, STUDENT, new Date(), "钦州", "毕业", "研发部");
        return EntityFactory.createResponse(userService.update(u));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestParam Map<String, String> map) {
        User u = getUserByUserType(map);
        User user = userService.updateEntity(u);
        if (user != null) return EntityFactory.createResponse(user, "保存成功");
        throw new UserExpcetion("保存失败");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestParam Map<String, String> map) {
        User u = getUserByUserType(map);
        User user = userService.insert(u);

        return EntityFactory.createResponse(user, "注册成功");

    }

    private User getUserByUserType(Map<String, String> map) {
        String userType = map.get("userType");
        User u = null;
        try {
            if (STUDENT == Integer.valueOf(userType)) {
                u = (Student) JsonUtils.fromJson(map.get("user"), Student.class);
            } else if (TEACHER == Integer.valueOf(userType)) {
                u = (Teacher) JsonUtils.fromJson(map.get("user"), Teacher.class);
            }
        } catch (Exception e) {
            throw new UserExpcetion(e);
        }

        return u;
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
