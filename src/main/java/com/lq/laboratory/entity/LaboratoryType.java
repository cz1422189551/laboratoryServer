package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lq.laboratory.entity.core.LaboratoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaboratoryType extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "laboratoryType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Laboratory> laboratoryList;


}
