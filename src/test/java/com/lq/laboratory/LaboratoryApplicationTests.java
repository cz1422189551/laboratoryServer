package com.lq.laboratory;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.repository.AppointmentRepository;
import com.lq.laboratory.repository.StatisticService;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.*;

import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.ParamUtil.createMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaboratoryApplicationTests {

    @Autowired
    UserServiceImpl userService;


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    StatisticService statisticRepository;


    @Test
    public void testStatisticImpl() {

        List<Appointment> list = statisticRepository.findDatePointUsingByDate(createMap(2018, 12, 25), STUDENT);
    }


    @Test
    public void test() throws ParseException {

        Map<String, Number> allMonthCountByYear = appointmentRepository.findAllMonthCountByYear(2018);
        int year = allMonthCountByYear.get("year").intValue();
        int month = allMonthCountByYear.get("month").intValue();
        int count = allMonthCountByYear.get("count").intValue();
    }


    @Test
    public void contextLoads() {
        List<User> all = userService.getAll();
        String s = JsonUtils.toJson(all);
    }

    @Test
    public void testDelete() {
        boolean delete = userService.delete(3 + "");

    }

}
