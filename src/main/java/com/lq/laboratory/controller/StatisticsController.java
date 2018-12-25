package com.lq.laboratory.controller;

import com.lq.laboratory.repository.StatisticService;
import com.lq.laboratory.services.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.ParamUtil.createMap;

@RestController
@RequestMapping("/statistic")
public class StatisticsController {

    @Autowired
    StatisticService statisticService;

    @RequestMapping("/startDatePoint")
    public List findStartDatePoint() {
        List list = statisticService.findDatePointUsingByDate(createMap(2018, 12), STUDENT);
        return list;
//        list.stream().map(l -> {
//            Map<String, Object> map = (Map<String, Object>) l;
//            return map;
//        }).forEach( m ->);
    }

}
