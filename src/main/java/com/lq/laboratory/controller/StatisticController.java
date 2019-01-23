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
        List everyMonthCountByYear = statisticService.findEveryMonthCountByYear(ParamUtil.createMap(2019));
        Map<String, Object> map = EntityFactory.getMap(everyMonthCountByYear, "list");
        return EntityFactory.createResponse(map);
    }

    //最近五日 : top10实验室
    @RequestMapping("/top/laboratory")
    public ResponseEntity laboratoryAppointTop10() {
        List top10NumberInWeek = statisticService.findTop10NumberInWeek();
        return EntityFactory.createResponse(top10NumberInWeek);
    }


    @RequestMapping("/monitor/disPlay")
    public ResponseEntity disPlayCount() {
        Map<String, Integer> map = statisticService.findCount();
        return EntityFactory.createResponse(map);
    }

    @RequestMapping("/startDatePoint")
    public ResponseEntity findStartDatePoint() {
        List studentList = statisticService.findDatePointUsingByDate(createMap(2019), STUDENT);
        List teacherList = statisticService.findDatePointUsingByDate(createMap(2019), TEACHER);

        Map<String, Object> map = EntityFactory.getMap(studentList, "student");
        map.put("teacher", teacherList);
        return EntityFactory.createResponse(map);

    }


}
