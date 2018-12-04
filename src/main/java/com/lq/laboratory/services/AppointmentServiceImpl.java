package com.lq.laboratory.services;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import com.lq.laboratory.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment> {

    @Autowired
    UserService userService;

    @Autowired
    LaboratorySeatServiceImpl laboratorySeatService;


    @Resource(name = "appointmentRepository")
    @Override
    public void setRepository(BaseRepository<Appointment, Integer> repository) {
        super.setRepository(repository);
    }
}
