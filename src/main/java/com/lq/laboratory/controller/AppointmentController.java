package com.lq.laboratory.controller;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Appointment appointment) {
        return EntityFactory.createResponse(appointmentService.insert(appointment));
    }

    //取消预约，将enable至为0
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancel(@RequestBody Appointment appointment) {
        return EntityFactory.createResponse(appointmentService.update(appointment));
    }

}
