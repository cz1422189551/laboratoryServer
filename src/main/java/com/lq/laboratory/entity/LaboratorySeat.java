package com.lq.laboratory.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "laboratory_seat")
public class LaboratorySeat extends BaseEntity {


    @Column(insertable = false, columnDefinition = "int default 1")
    private Integer stateType;

    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;


    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

}
