package com.lq.laboratory.services;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.services.base.BaseServiceImpl;
import com.lq.laboratory.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment> {

    @Autowired
    UserService userService;

//    @Autowired
//    LaboratorySeatServiceImpl laboratorySeatService;


    @Transactional
    @Override
    public Appointment insert(Appointment appointment) {

        try {
            List<Appointment> all = getAll(AppointmentSpecification.findOccupationInfo(
                    appointment.getLaboratory().getId() + "", appointment.getAppointmentDate(),
                    appointment.getEndDate(), appointment.getDate()
            ));

            if (all == null || all.size() < appointment.getLaboratory().getSeatCount()) {
                return super.insert(appointment);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Resource(name = "appointmentRepository")
    @Override
    public void setRepository(BaseRepository<Appointment, Integer> repository) {
        super.setRepository(repository);
    }
}
