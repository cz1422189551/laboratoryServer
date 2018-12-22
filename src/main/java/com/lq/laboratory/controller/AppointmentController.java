package com.lq.laboratory.controller;

import com.google.gson.Gson;
import com.lq.laboratory.entity.*;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.repository.specifi.UserSpecification;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.services.LaboratoryServiceImpl;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Autowired
    UserServiceImpl service;

    @Autowired
    LaboratoryServiceImpl laboratoryService;


    @RequestMapping(value = "/available")
    public List<Appointment> queryAvailableLaboratory(@RequestParam Map<String, String> map) throws ParseException {
        int minute = Integer.valueOf(map.get("minute"));
        String startDate = map.get("startDate");

        Date date = DateUtil.addMinute(DateUtil.stringToDateWithTime(startDate), minute);
        map.put("endDate", DateUtil.DateToString(date));

        //该时间段已经被占用的集合
        List<Appointment> occupation = appointmentService.getAll(AppointmentSpecification.findOccupationInfo(map));

        return occupation;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity appointment(@RequestParam Map<String, String> map) throws ParseException {


        Appointment appointment = (Appointment) JsonUtils.fromJson(map.get("appointment"), Appointment.class);

        Date startDate = appointment.getAppointmentDate();
        appointment.setEndDate(DateUtil.addMinute(startDate, appointment.getMinute()));
        Appointment insert = appointmentService.insert(appointment);
        return EntityFactory.createResponse(insert);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result getList(@RequestParam Map<String, String> map) throws ParseException {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = appointmentService.getList(AppointmentSpecification.<Appointment>getListByUserName(map.get("userId")), pageNum, pageSize);
        Result result = EntityFactory.createResult(page);
        return result;
    }


    //取消预约，将enable至为0
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancel(@RequestParam Map<String, String> map) {
        String json = map.get("myAppointment");
        Appointment appointment = (Appointment) JsonUtils.fromJson(json, Appointment.class);
        appointment.setState(Const.CANCEL);
        return EntityFactory.createResponse(appointmentService.update(appointment));
    }

}
