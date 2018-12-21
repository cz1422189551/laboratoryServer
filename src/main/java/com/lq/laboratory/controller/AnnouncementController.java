package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.services.base.IService;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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

    @RequestMapping("/getList")
    public Result getList(@RequestParam Map<String, String> map) {
        Result<Announcement> list = service.getList(Integer.valueOf(map.get("pageNum")), Integer.valueOf(map.get("pageSize")));
        return list;
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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity update(@RequestParam("id") String id) {
        return EntityFactory.createResponse(service.delete(id));

    }

    @RequestMapping()
    public ModelAndView page() {
        return new ModelAndView("announcement");
    }
}
