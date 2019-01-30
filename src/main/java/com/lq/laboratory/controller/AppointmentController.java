package com.lq.laboratory.controller;

import com.google.gson.Gson;
import com.lq.laboratory.entity.*;
import com.lq.laboratory.exception.AppointmentException;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.repository.specifi.UserSpecification;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.services.LaboratoryServiceImpl;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.APPOINTING;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Autowired
    UserServiceImpl service;


    //app:查询某教室，某时段是否还有可用座位
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

    //app:获取某用户的预约信息（分页）
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result getList(@RequestParam Map<String, String> map) {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = appointmentService.getList(AppointmentSpecification.getListByUserName(map.get("userId")), pageNum, pageSize);
        Result result = EntityFactory.createResult(page);
        return result;
    }


    //app:添加预约
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity appointment(@RequestParam Map<String, String> map) {
        Appointment appointment = (Appointment) JsonUtils.fromJson(map.get("appointment"), Appointment.class);
        Date startDate = appointment.getAppointmentDate();
        Appointment insert = insertAppoint(appointment, startDate);
        return EntityFactory.createResponse(insert);
    }


    //app:模糊查询预约信息 通过实验室名称 和 日期
    @RequestMapping(value = "/getListByName")
    public Result findByNameAndDate(@RequestParam Map<String, String> map) throws ParseException {
        String laboratoryName = map.get("laboratoryName");
        String date = map.get("date");
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page list = null;
        if (laboratoryName == null || "".equals(laboratoryName)) {
            map.put("state", APPOINTING + "");
            list = appointmentService.getList(
                    AppointmentSpecification.findByDate(DateUtil.stringToDate(date)), pageNum, pageSize);
        } else {
            Specification byNameAndDate = AppointmentSpecification.findByNameAndDate(laboratoryName, DateUtil.stringToDate(date));
            list = appointmentService.getList(byNameAndDate, pageNum, pageSize);
        }
        return EntityFactory.createResult(list);
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ResponseEntity updateAppointment(@RequestBody Appointment appointment) throws ParseException {

        Date startDate = appointment.getAppointmentDate();
        appointment.setEndDate(DateUtil.addMinute(startDate, appointment.getMinute()));
        Appointment modify = appointmentService.modify(appointment);
        return EntityFactory.createResponse(modify);
    }


    @RequestMapping(value = "/admin/getList", method = RequestMethod.GET)
    public ResponseEntity adminGetList(@RequestParam Map<String, String> map) {
        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = appointmentService.getList(BaseSpecification.<Appointment>findByAnd(map), pageNum, pageSize);
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }


    @RequestMapping(value = "/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestBody Map<String, Object> map) {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");

        Page<Appointment> page = appointmentService.getList(
                AppointmentSpecification.findByPredicate((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }


    //app:取消预约，将enable至为0
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancel(@RequestParam Map<String, String> map) {
        String json = map.get("myAppointment");
        Appointment appointment = (Appointment) JsonUtils.fromJson(json, Appointment.class);
        return doCancel(appointment);
    }

    //取消预约，将enable至为0
    @RequestMapping(value = "admin/cancel", method = RequestMethod.POST)
    public ResponseEntity adminCancel(@RequestBody Appointment appointment) {
        return doCancel(appointment);
    }

    private ResponseEntity doCancel(Appointment appointment) {
        appointment.setState(Const.CANCEL);
        return EntityFactory.createResponse(appointmentService.update(appointment));
    }


    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseEntity delete(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        Appointment one = appointmentService.getOne(id);
        DeleteUtil.releaseAppointment(one);
        appointmentService.delete(one);
        return EntityFactory.createResponse(true);
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Appointment appointment) {
        Date startDate = appointment.getAppointmentDate();
        if (startDate == null || appointment.getMinute() < 1) throw new AppointmentException("填完时间完整信息");
        Appointment insert = insertAppoint(appointment, startDate);
        return EntityFactory.createResponse(insert);
    }

    private Appointment insertAppoint(Appointment appointment, Date startDate) {
        appointment.setEndDate(DateUtil.addMinute(startDate, appointment.getMinute()));
        appointment.setCreateDate(new Date());
        return appointmentService.insert(appointment);
    }


}
