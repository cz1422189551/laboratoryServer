package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;

import com.lq.laboratory.repository.specifi.AnnouncementSpecification;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.services.base.IService;
import com.lq.laboratory.util.DateUtil;
import com.lq.laboratory.util.EntityFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@RestController()
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    IService<Announcement> service;

    //app:获取公告列表（分页）
    @RequestMapping("/getList")
    public Result getList(@RequestParam Map<String, String> map) {
        Result<Announcement> list = service.getList(Integer.valueOf(map.get("pageNum")), Integer.valueOf(map.get("pageSize")));
        return list;
    }

    @RequestMapping(value = "/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity adminGetList(@RequestBody Map<String, Object> map)   {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");

        Page<Announcement> page = service.getList(
                AnnouncementSpecification.findByPredicate((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }




    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Announcement announcement) {
        setDateTime(announcement);
        return EntityFactory.createResponse(service.insert(announcement));
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Announcement announcement) {
        setDateTime(announcement);
        return EntityFactory.createResponse(service.update(announcement));

    }

    private void setDateTime(@RequestBody Announcement announcement) {
        announcement.setDate(DateUtil.localDateToDate(LocalDate.now()));
        announcement.setPushDate(new Date());
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseEntity delete(@RequestBody Map<String, String> map) {
        return EntityFactory.createResponse(service.delete(map.get("id")));

    }


}
