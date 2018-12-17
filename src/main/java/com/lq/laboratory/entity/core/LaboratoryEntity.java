package com.lq.laboratory.entity.core;

import com.lq.laboratory.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryEntity extends Laboratory {

    private List<LaboratorySeat> seatInfoList;

    public LaboratoryEntity(int id, User user, String name, List<LaboratorySeat> seatInfoList, int row, int col, boolean enable, Date openDate, Date closeDate, LaboratoryType laboratoryType) {
        super(id, user, name, null, row, col, enable, openDate, closeDate, laboratoryType);
        this.seatInfoList = seatInfoList;
    }


    public LaboratoryEntity(Laboratory l, List<LaboratorySeat> seatInfoList) {
        this(l.getId(), l.getUser(), l.getName(), seatInfoList, l.getRow(), l.getCol(), l.isEnable(), l.getOpenDate(), l.getCloseDate(), l.getLaboratoryType());
    }
}
