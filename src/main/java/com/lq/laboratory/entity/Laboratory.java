package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laboratory extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "laboratory_seat"
            , inverseJoinColumns = @JoinColumn(name = "seat_id")
            , joinColumns = @JoinColumn(name = "laboratory_id"))
    private List<Seat> seatList;

//    private LaboratoryType type;

    //排
    private int row;
    //列
    private int col;


    //是否启用
    private boolean enable;

    //开放时间
    private Date openDate;

    //关闭时间
    private Date closeDate;

}
