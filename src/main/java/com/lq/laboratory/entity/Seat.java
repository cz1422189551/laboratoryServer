package com.lq.laboratory.entity;

import com.lq.laboratory.util.FormatUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat extends BaseEntity {

    private String name;
    //第几排
    private int rowIndex;
    //第几列
    private int colIndex;

    //别名
    private String rowName;

    @ManyToMany(mappedBy = "seatList" )
    private List<Laboratory> laboratory;


    public Seat(int rowIndex, int colIndex) {
        this(FormatUtil.changeRow(rowIndex) + "" + colIndex,rowIndex,colIndex);
    }

    public Seat(String name, int rowIndex, int colIndex) {
        this.name = name;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }
}
