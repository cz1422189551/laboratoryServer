package com.lq.laboratory.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laboratory extends BaseEntity {

    @ManyToOne
    @Getter
    @Setter
    private User user;

    @ManyToMany
    @JoinTable(name = "laboratory_seat"
            , inverseJoinColumns = @JoinColumn(name = "seat_id")
            , joinColumns = @JoinColumn(name = "laboratory_id"))
    @Getter
    @Setter
    private List<Seat> seatList;

//    private LaboratoryType type;

    //排
    @Getter
    @Setter
    private int row;
    //列
    @Getter
    @Setter
    private int col;


    //是否启用
    @Getter
    @Setter
    private boolean enable;

    //开放时间
    @Getter
    @Setter
    private Date openDate;

    //关闭时间
    @Getter
    @Setter
    private Date closeDate;


    @Override
    public String toString() {
        return "Laboratory{" +
                "user=" + user +
                ", row=" + row +
                ", col=" + col +
                ", enable=" + enable +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", id=" + id +
                '}';
    }
}
