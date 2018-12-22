package com.lq.laboratory.entity;


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

    @OneToMany(
            mappedBy = "laboratoryType",
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Laboratory> laboratoryList;


}
