package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "date"),@Index(columnList = "appointmentDate")})
public class Appointment extends BaseEntity {

    //预约的用户
    @ManyToOne
    private User user;

    //座位
    @OneToOne
    private Laboratory laboratory;

    //创建时间
    private Date createDate;

    //预约的时间
    private Date appointmentDate;

    //结束时间
    private Date endDate;

    //日期
    @Temporal(TemporalType.DATE)
    private Date date;

    //分钟
    private int minute = 30;


    //预约状态，1 预约中 ， 0 取消预约
    private int state = 1;

}
