package com.lq.laboratory.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Laboratory extends BaseEntity {

    @ManyToOne

    private User user;

    private String name;

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


    @Override
    public String toString() {
        return "Laboratory{" +
                "user=" + user +
                ",name=" + name +
                ", row=" + row +
                ", col=" + col +
                ", enable=" + enable +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", id=" + id +
                '}';
    }
}
