package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.repository.specifi.CommentSpecifition;
import com.lq.laboratory.services.CommentServiceImpl;
import com.lq.laboratory.services.base.BaseServiceImpl;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.DateUtil;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import com.lq.laboratory.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    UserService userService;


    @RequestMapping("/getList")
    public Result<Comment> getList(@RequestParam Map<String, String> map) {
        int useId = Integer.valueOf(map.get("user"));
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page list = commentService.getList(CommentSpecifition.findByUser(useId), pageNum, pageSize);
        Result result = EntityFactory.createResult(list);
        return result;
    }

    @RequestMapping("/getList/laboratory")
    public Result<Comment> getListInLaboratory(@RequestParam Map<String, String> map) {
        int laboratoryId = Integer.valueOf(map.get("laboratory"));
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page list = commentService.getList(CommentSpecifition.findByLaboratry(laboratoryId), pageNum, pageSize);
        Result result = EntityFactory.createResult(list);
        return result;
    }

    @RequestMapping("/add")
    public ResponseEntity<Comment> add(@RequestParam Map<String, String> map) {
        String json = map.get("comment");
        Comment comment = (Comment) JsonUtils.fromJson(json, Comment.class);
        Comment insert = commentService.insert(comment);
        return EntityFactory.createResponse(insert);
    }

    @RequestMapping(value = "/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestBody Map<String, Object> map) throws ParseException {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");
        Page<Comment> page = commentService.getList(
                CommentSpecifition.findByPredicate((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ResponseEntity adminUpdate(@RequestBody Comment comment) throws UnsupportedEncodingException {
        comment.setTime(new Date());
        Comment comment1 = commentService.updateEntity(comment);
        return EntityFactory.createResponse(comment1);
    }


    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseEntity updateAppointment(@RequestBody Comment comment) throws ParseException {
        comment.setTime(new Date());
        return EntityFactory.createResponse(commentService.insert(comment));
    }

    //实验室删除
    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseEntity deleteLab(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        Comment comment = commentService.getOne(id);
        User user = comment.getUser();
        //移除该节点的评论
        user.getCommentList().remove(comment);

        Laboratory laboratory = comment.getLaboratory();
        //移除该节点的
        laboratory.getCommentList().remove(comment);
//        laboratory.getCommentList().stream().forEach(cm -> {
//            cm.setLaboratory(null);
//        });
        comment.setUser(null);
        comment.setLaboratory(null);

        commentService.delete(comment);
        return EntityFactory.createResponse("ok");
    }

}
