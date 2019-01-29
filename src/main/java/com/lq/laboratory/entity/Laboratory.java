package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Laboratory extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn
    private User user;

    private String name;


    public Laboratory(int id, User user, String name, int row, int col, boolean enable, Date openDate, Date closeDate, LaboratoryType laboratoryType) {
        super(id);
        this.user = user;
        this.name = name;
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


    //学生是否可用 1可用 ， 2不可用
    private int availableType = 1;

    //是否启用
    private boolean enable;

    //开放时间

    private Date openDate;

    //关闭时间

    private Date closeDate;

    private String description;

    private String address;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE
    )
    @JoinColumn
    @JsonIgnoreProperties(value = "laboratoryList")
    private LaboratoryType laboratoryType;


    @OneToMany(
            mappedBy = "laboratory"
            , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            ,orphanRemoval = true
    )
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(
            mappedBy = "laboratory"
            , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            , orphanRemoval = true
    )
    @JsonIgnore
    private List<Comment> commentList;


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
