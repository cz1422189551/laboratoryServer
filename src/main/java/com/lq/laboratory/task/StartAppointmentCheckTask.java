package com.lq.laboratory.task;

import com.lq.laboratory.services.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartAppointmentCheckTask implements Runnable {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Override
    public void run() {
        checkUpdateAppointment();
    }

    private void checkUpdateAppointment() {
        System.out.println("启动时：更新过期时间的使用中，正在使用的状态");
        appointmentService.updateBeforeDateStateToFinish();
    }
}
