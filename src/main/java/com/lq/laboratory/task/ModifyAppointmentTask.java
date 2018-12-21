package com.lq.laboratory.task;


import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.services.AppointmentServiceImpl;
import com.lq.laboratory.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.lq.laboratory.util.Const.USING;


@Component
public class ModifyAppointmentTask {

    @Autowired
    AppointmentServiceImpl service;


    //每天8点到20点，每隔30分钟，更新状态
    @Scheduled(cron = "0 */30 8-20 * * ?")
    public void updateState() {
        LocalDate date = LocalDate.now();
        System.out.println("执行 : " + LocalDateTime.now());

        int appointToUsing = service.updateAppointToUsing(DateUtil.localDateToDate(date), DateUtil.localDateTimeToDate(LocalDateTime.now()));
        int usedToFinish = service.updateUsingToFinish(DateUtil.localDateToDate(date), DateUtil.localDateTimeToDate(LocalDateTime.now()));

        System.out.println("appointToUsing : " + appointToUsing);
        System.out.println("usedToFinish : " + usedToFinish);

    }

}
