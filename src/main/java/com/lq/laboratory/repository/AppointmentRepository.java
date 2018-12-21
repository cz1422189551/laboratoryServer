package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Appointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface AppointmentRepository extends BaseRepository<Appointment, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update appointment  set state=:used where  date=:today and appointment_date<=:currentDate and state=:appoint and end_date>:currentDate")
    int updateAppointStateToUsing(@Param("used") int used, @Param("today") Date today
            , @Param("currentDate") Date currentDate, @Param("appoint") int appoint);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update appointment  set state=:finish where  date=:today and appointment_date<:currentDate and state=:used and end_date<:currentDate")
    int updateAppointStateToFinsh(@Param("finish") int finish, @Param("today") Date today
            , @Param("currentDate") Date currentDate, @Param("used") int used);

}
