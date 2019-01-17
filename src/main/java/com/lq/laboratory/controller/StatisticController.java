package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.repository.StatisticService;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.util.DateUtilByAndroid;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.Const.TEACHER;
import static com.lq.laboratory.util.ParamUtil.createMap;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping("/home")
    public ResponseEntity findEveryMonthAppointCountByYear() {
        List everyMonthCountByYear = statisticService.findEveryMonthCountByYear(ParamUtil.createMap(2018));
        Map<String, Object> map = EntityFactory.getMap(everyMonthCountByYear, "list");
        return EntityFactory.createResponse(map);
    }


    @RequestMapping("/monitor/disPlay")
    public ResponseEntity disPlayCount() {
        Map<String, Integer> map = statisticService.findCount();
        return EntityFactory.createResponse(map);
    }

    @RequestMapping("/startDatePoint")
    public ResponseEntity findStartDatePoint() {
        List studentList = statisticService.findDatePointUsingByDate(createMap(2018), STUDENT);
        List teacherList = statisticService.findDatePointUsingByDate(createMap(2018), TEACHER);

        Map<String, Object> map = EntityFactory.getMap(studentList, "student");
        map.put("teacher", teacherList);
//        List list = new ArrayList();
//        list.add(studentMap);
//        list.add(teacherMap);

        return EntityFactory.createResponse(map);
//        list.stream().map(l -> {
//            Map<String, Object> map = (Map<String, Object>) l;
//            return map;
//        }).forEach( m ->);
    }




}
