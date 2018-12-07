package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.Student;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.services.StudentServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/getList")
    public ResponseEntity getList(@RequestParam Map<String, String> map) {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = studentService.getList(BaseSpecification.<Student>findByAnd(map), pageNum, pageSize);
        return EntityFactory.createResponse(EntityFactory.createResult(page));
    }

}
