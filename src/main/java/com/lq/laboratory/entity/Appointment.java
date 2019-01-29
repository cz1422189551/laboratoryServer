package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(indexes = {@Index(columnList = "date"), @Index(columnList = "state"), @Index(columnList = "appointmentDate")})
public class Appointment extends BaseEntity {

    //预约的用户
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn
    private User user;

    //座位
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn
    private Laboratory laboratory;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createDate;

    //预约的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date appointmentDate;

    //结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endDate;

    //日期
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    //分钟
    private int minute = 30;


    //预约状态，1 预约中 ， 0 取消预约
    private int state = 1;

}
