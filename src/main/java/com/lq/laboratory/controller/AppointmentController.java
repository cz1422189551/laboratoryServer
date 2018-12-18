package com.lq.laboratory.controller;

import com.google.gson.Gson;
import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.services.LaboratoryServiceImpl;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.DateUtil;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Appointment appointment(@RequestParam Map<String, String> map) throws ParseException {

        Gson gson = new Gson();
        Appointment appointment = gson.fromJson(map.get("appointment"), Appointment.class);

        Date startDate = appointment.getAppointmentDate();
        appointment.setEndDate(DateUtil.addMinute(startDate, appointment.getMinute()));
        Appointment insert = appointmentService.insert(appointment);
        return insert;
    }


    //取消预约，将enable至为0
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancel(@RequestBody Appointment appointment) {
        return EntityFactory.createResponse(appointmentService.update(appointment));
    }

}
