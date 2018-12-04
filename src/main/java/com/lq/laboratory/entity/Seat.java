package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lq.laboratory.util.FormatUtil;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Seat extends BaseEntity {


    private String name;
    //第几排

    private int rowIndex;
    //第几列

    private int colIndex;

    //别名

    private String rowName;


    public Seat(int rowIndex, int colIndex) {
        this(FormatUtil.changeRow(rowIndex) + "" + colIndex, rowIndex, colIndex);
    }

    public Seat(String name, int rowIndex, int colIndex) {
        this.name = name;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }


}
