package com.lq.laboratory.services;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.exception.AppointmentException;
import com.lq.laboratory.repository.AppointmentRepository;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.specifi.AppointmentSpecification;
import com.lq.laboratory.services.base.BaseServiceImpl;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.lq.laboratory.util.Const.*;

@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment> {

    @Autowired
    UserService userService;

    AppointmentRepository appointmentRepository;


    /**
     * 将预约状态 -> 使用状态
     *
     * @param date        当天日期
     * @param currentDate 当前时间
     * @return
     */
    @Transactional
    public int updateAppointToUsing(Date date, Date currentDate) {
        return appointmentRepository.updateAppointStateToUsing(
                USING, date, currentDate, APPOINTING
        );
    }

    /**
     * 将使用状态 -> 完成状态
     *
     * @param date        当天日期
     * @param currentDate 当前时间
     * @return
     */
    @Transactional
    public int updateUsingToFinish(Date date, Date currentDate) {
        return appointmentRepository.updateAppointStateToFinsh(
                USING, date, currentDate, APPOINTING
        );
    }


    @Transactional
    @Override
    public Appointment insert(Appointment appointment) {

        try {
            User user = appointment.getUser();
            //判断时间冲突
            if (!validateTimeConflict(appointment, user)
                    && !validateDateTime(appointment.getAppointmentDate(), appointment.getEndDate())
                    && !validateAvailDateSeat(appointment, user))
                return super.insert(appointment);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //检查时间是否失效
    private boolean validateDateTime(Date startDate, Date endDate) {
        long currentTime = System.currentTimeMillis();
        long appointTime = startDate.getTime();
        if (currentTime - appointTime >= 0) throw new AppointmentException("不能预约已经过去的时间");
        return false;
    }


    //检查是否预约冲突
    private boolean validateTimeConflict(Appointment appointment, User user) {
        try {
            List<Appointment> all = getAll(AppointmentSpecification.findConflictDate(user.getId() + "", appointment.getAppointmentDate(), appointment.getEndDate(), appointment.getDate()));
            if (all != null && all.size() > 0) throw new AppointmentException("已有约在身");
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Resource(name = "appointmentRepository")
    @Override
    public void setRepository(BaseRepository<Appointment, Integer> repository) {
        super.setRepository(repository);
        appointmentRepository = (AppointmentRepository) repository;
    }

    //判断想要预约的实验室可用数量， 可用则 返回false
    private boolean validateAvailDateSeat(Appointment appointment, User user) throws ParseException {
        List<Appointment> all = getAll(AppointmentSpecification.findOccupationInfo(
                appointment.getLaboratory().getId() + "", appointment.getAppointmentDate(),
                appointment.getEndDate(), appointment.getDate()
        ));
        //都是空位
        if (all == null) return false;
        if (appointment.getLaboratory().getAvailableType() == STUDENT) { //学生实验室
            if (user.getUserType() == STUDENT) {
                //等于最大预约数
                if (all.size() == SEAT_COUNT) throw new AppointmentException("学生实验室只能被学生预约 " + SEAT_COUNT + "个位置");
            }
            //判断是否已满
            if (all.size() == appointment.getLaboratory().getSeatCount()) throw new AppointmentException("该时段位置已满");
            return false;
        } else { //教师实验室
            if (user.getUserType() != TEACHER)
                throw new AppointmentException("非教职人员无法预约" + appointment.getLaboratory().getName());
            if (all.size() > 0) throw new AppointmentException("该时段已被预约");
            return false;
        }
    }

}
