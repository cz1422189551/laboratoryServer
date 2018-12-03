package com.lq.laboratory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name="laboratory_seat")
public class LaboratorySeat extends BaseEntity {

    //座位的状态
    private int state;

    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;


    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

}
