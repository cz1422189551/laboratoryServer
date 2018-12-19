package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.util.DateUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AppointmentSpecification extends BaseSpecification<Appointment> {

    private String restTime = "12:00-15:00";


    public static Specification<Appointment> getListByUserName(String userId) {
        return (root, query, cb) -> cb.equal(
                root.get("user").get("id"), userId
        );
    }


    public static Specification<Appointment> findOccupationInfo(String laboratoryId, Date startDate, Date endDate, Date date) throws ParseException {

        return getAppointmentSpecification(laboratoryId, startDate, endDate, date);
    }

    private static Specification<Appointment> getAppointmentSpecification(String laboratoryId, Date startDate, Date endDate, Date date) {
        return (root, query, cb) -> {
            Path<Object> laboratory = root.get("laboratory");
            Path<Date> datePath = root.get("date");
            Path<Date> startDatePath = root.get("appointmentDate");
            Path<Date> endDatePath = root.get("endDate");
            //预约中的
            int state = 1;
            Predicate p1 = cb.and(
                    cb.and(
                            cb.equal(laboratory.get("id"), Integer.valueOf(laboratoryId)),
                            cb.equal(datePath, date)
                    )
                    , cb.equal(root.get("state"), state));

            Predicate p2 = cb.and(
                    cb.lessThanOrEqualTo(startDatePath, startDate),
                    cb.greaterThanOrEqualTo(endDatePath, endDate)
            );

            Predicate orAndP1 = cb.and(
                    cb.greaterThan(endDatePath, startDate),
                    cb.lessThanOrEqualTo(endDatePath, endDate)
            );
            //第一个条件
            Predicate orP1 = cb.and(
                    cb.lessThanOrEqualTo(startDatePath, startDate),
                    orAndP1
            );
            //第二个条件
            Predicate orP2 = cb.and(
                    cb.greaterThanOrEqualTo(startDatePath, startDate),
                    cb.lessThan(startDatePath, endDate)
            );
            Predicate p3 = cb.or(cb.or(p2, orP1), orP2);
            return cb.and(p1, p3);
        };
    }

    /**
     * 查询某个时间段被占用的实验室信息
     *
     * @param map
     * @return
     */
    public static Specification<Appointment> findOccupationInfo(Map<String, String> map) throws ParseException {
        String laboratoryId = map.get("laboratoryId");
        String startDateStr = map.get("startDate");
        String enDateStr = map.get("endDate");
        String dateStr = map.get("date");
        Date startDate = DateUtil.stringToDateWithTime(startDateStr);
        Date endDate = DateUtil.stringToDateWithTime(enDateStr);
        Date date = DateUtil.stringToDate(dateStr);
        return getAppointmentSpecification(laboratoryId, startDate, endDate, date);
    }

    String sql = "select ap.id ,ap.appointment_date '预约时间' , ap.end_date '结束时间',\n" +
            "ap.`minute` '分钟' ,ap.date '日期' from  appointment ap\n" +
            "where laboratory_id=1\n" +
            "and state=1\n" +
            "and date='2018-12-19'\n" +
            "and (\n" +
            "appointment_date<='2018-12-19 09:00' and end_date>='2018-12-19 10:00'\n" +
            "or appointment_date<='2018-12-19 09:00' and (end_date>'2018-12-19 09:00'and end_date<='2018-12-19 10:00')\n" +
            "or (appointment_date>='2018-12-19 09:00' and appointment_date<'2018-12-19 10:00' )\n" +
            ")";

}
