package com.lq.laboratory.controller;


import com.lq.laboratory.entity.*;
import com.lq.laboratory.exception.UserExpcetion;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.repository.specifi.UserSpecification;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import com.lq.laboratory.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.lq.laboratory.util.Const.ADMIN;
import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.Const.TEACHER;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


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

    @RequestMapping(value = "/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestBody Map<String, Object> map) throws ParseException {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");
        Page<User> page = userService.getList(
                UserSpecification.findByPredicate((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }

    @RequestMapping("/getList")
    public ResponseEntity getList(@RequestParam Map<String, String> map) {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = userService.getList(UserSpecification.<User>findByAnd(map), pageNum, pageSize);

        return EntityFactory.createResponse(EntityFactory.createResult(page));
    }

    //获取非学生的用户
    @RequestMapping("/admin")
    public ResponseEntity getList() {
        List<User> userType = userService.getAll((root, query, cb) -> cb.notEqual(root.get("userType"), STUDENT));
        return EntityFactory.createResponse(userType);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(String fsFormData) {
        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
        return EntityFactory.createResponse(userService.insert(u));

    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseEntity adminAdd(@RequestBody User user) throws UnsupportedEncodingException {
        if (user == null || !vailDateStr(user)) throw new UserExpcetion("完善信息");
        return EntityFactory.createResponse(userService.insert(user));
    }

    private boolean vailDateStr(User user) {
        return (!StringUtils.isEmpty(user.getUserName())
                && !StringUtils.isEmpty(user.getPassword())
                && !StringUtils.isEmpty(user.getName())
                && !StringUtils.isEmpty(user.getTel()));
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(String fsFormData) throws UnsupportedEncodingException {
        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
        return EntityFactory.createResponse(userService.update(u));
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ResponseEntity adminUpdate(@RequestBody User user) throws UnsupportedEncodingException {
//        User u = (User) JsonUtils.fromJson(fsFormData, User.class);
        User user1 = userService.updateEntity(user);
        return EntityFactory.createResponse(user1);
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseEntity delete(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        return EntityFactory.createResponse(userService.delete(id));
    }


    //app更新
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestParam Map<String, String> map) {
        User u = getUserByUserType(map);
        User user = userService.updateEntity(u);
        if (user != null) return EntityFactory.createResponse(user, "保存成功");
        throw new UserExpcetion("保存失败");
    }

    //app注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestParam Map<String, String> map) {
        User u = getUserByUserType(map);
        User user = userService.insert(u);

        return EntityFactory.createResponse(user, "注册成功");

    }


    @RequestMapping(value = "/admin/type/cascade")
    public List<Map<String, Object>> adminQueryCascade() {
        List<User> all = userService.getAll();
        Map<Integer, List<User>> collect = all.stream().collect(Collectors.groupingBy(User::getUserType));

        List<Map<String, Object>> result = collect.entrySet().stream().map(entry -> {
            Map<String, Object> map = new HashMap<>();
            map.put("label", FormatUtil.userTypeToStr(entry.getKey()));
            map.put("value", entry.getKey() + "_");

            List<Map<String, Object>> collect1 = entry.getValue().stream().map(v -> {
                Map<String, Object> childrenMap = new HashMap<>();
                childrenMap.put("label", v.getUserName());
                childrenMap.put("value", v.getId());
                childrenMap.put("children", null);
//                childrenMap.put("tel", v.getTel());
                return childrenMap;
            }).collect(Collectors.toList());
            map.put("children", collect1);
            return map;
        }).collect(Collectors.toList());
        return result;
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


}
