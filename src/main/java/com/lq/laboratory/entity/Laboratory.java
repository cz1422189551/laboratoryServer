package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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

//    @ManyToMany
//    @JoinTable(name = "laboratory_seat"
//            , inverseJoinColumns = @JoinColumn(name = "seat_id")
//            , joinColumns = @JoinColumn(name = "laboratory_id"))
//    private List<Seat> seatList;

    public Laboratory(int id, User user, String name, int row, int col, boolean enable, Date openDate, Date closeDate, LaboratoryType laboratoryType) {
        super(id);
        this.user = user;
        this.name = name;
//        this.seatList = seatList;
        this.row = row;
        this.col = col;
        this.enable = enable;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.laboratoryType = laboratoryType;
    }


//排

    private int row;
    //列

    private int col;

    //座位数量
    private int seatCount;

    //是否启用

    private boolean enable;

    //开放时间

    private Date openDate;

    //关闭时间

    private Date closeDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonIgnore
    private LaboratoryType laboratoryType;

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
