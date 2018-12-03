package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.services.IService;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static com.lq.laboratory.services.Const.STUDENT;

@RestController()
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    IService<Announcement> service;

    @RequestMapping("/one/{id}")
    public ResponseEntity getOne(@PathVariable("id") String id) {

        Announcement announcement = service.getOne(id);
        return EntityFactory.createResponse(announcement);
    }

    @RequestMapping("/list/{pageNumber}/{pageSize}")
    public ResponseEntity getList(@PathVariable("pageNumber") int pageNumber
            , @PathVariable("pageSize") int pageSize) {

        Result<Announcement> list = service.getList(pageNumber, pageSize);
        return EntityFactory.createResponse(list);
    }

    @RequestMapping("/all")
    public ResponseEntity getAll() {
        return EntityFactory.createResponse(service.getAll());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Announcement announcement) {
        return EntityFactory.createResponse(service.insert(announcement));
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Announcement announcement) {
        return EntityFactory.createResponse(service.update(announcement));

    }

    @RequestMapping()
    public ModelAndView page() {
        return new ModelAndView("user");
    }
}
