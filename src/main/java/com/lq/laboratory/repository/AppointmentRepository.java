package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Appointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface AppointmentRepository extends BaseRepository<Appointment, Integer> {


    @Query(nativeQuery = true,
            value = "select (appointment_date) as 'startDatePoint',avg(`minute`)as 'avgMinute',sum(`minute`) as'sumMinute'\n" +
                    ",sum(seat_count) as 'sumSeatCount',count(1)state\n" +
                    "from appointment_info_view\n" +
                    "where year(date)=2018 and available_type=1\n" +
                    "GROUP BY appointment_date,seat_count\n" +
                    "having state>=1"
    )
    Map<String, Object> findAppointmentDateUsingByYear();

    @Query(nativeQuery = true,
            value = "select year(ap.appointment_date) as 'year',MONTH(ap.appointment_date) as 'month',count(id) as 'count'\n" +
                    "from appointment ap where year(date)=:queryYear\n" +
                    "group by year(ap.appointment_date),MONTH(ap.appointment_date)"
    )
        //某年十二个月（包括取消的）预约数量
    Map<String, Number> findAllMonthCountByYear(@Param("queryYear") int year);


    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update appointment  set state=:used where  date=:today and appointment_date<=:currentDate and state=:appoint and end_date>:currentDate")
    int updateAppointStateToUsing(@Param("used") int used, @Param("today") Date today
            , @Param("currentDate") Date currentDate, @Param("appoint") int appoint);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update appointment  set state=:finish where  date=:today and appointment_date<:currentDate and state=:used and end_date<:currentDate")
    int updateAppointStateToFinsh(@Param("finish") int finish, @Param("today") Date today
            , @Param("currentDate") Date currentDate, @Param("used") int used);


}
