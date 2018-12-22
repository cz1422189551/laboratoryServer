package com.lq.laboratory.controller;

import com.lq.laboratory.entity.Announcement;
import com.lq.laboratory.entity.Comment;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.repository.specifi.CommentSpecifition;
import com.lq.laboratory.services.CommentServiceImpl;
import com.lq.laboratory.services.base.BaseServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;


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

}
