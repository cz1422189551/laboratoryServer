package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import java.util.Date;

/**
 * 预约表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment extends BaseEntity {

    //预约的用户
    @ManyToOne
    private User user;

    //座位
    @OneToOne
    private LaboratorySeat laboratorySeat;

    //创建时间
    private Date createDate;

    //预约的时间
    private Date appointmentDate;

    //结束时间
    private Date endDate;

    //预约状态，1 预约中 ， 2 取消预约
    private int enable;

}
