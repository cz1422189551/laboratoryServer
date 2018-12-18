package com.lq.laboratory.controller;

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

    @RequestMapping(value = "/add")
    public ResponseEntity add() throws ParseException {
        User user = service.getUserByUserNameAndPassword("q", "q");
        Laboratory laboratory = laboratoryService.getOne(1 + "");
        Date appointmentDate = DateUtil.stringToDate("2018-12-19 9:00");
        int minutes = 5 * 30;

        Date endDate = DateUtil.addMinute(appointmentDate, minutes);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Appointment ap = new Appointment(
                user, laboratory, new Date(), appointmentDate, endDate, appointmentDate, 30, 1
        );
        return EntityFactory.createResponse(appointmentService.insert(ap));
    }


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


    //取消预约，将enable至为0
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancel(@RequestBody Appointment appointment) {
        return EntityFactory.createResponse(appointmentService.update(appointment));
    }

}
