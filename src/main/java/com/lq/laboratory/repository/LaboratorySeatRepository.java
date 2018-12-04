package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.LaboratorySeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LaboratorySeatRepository extends JpaRepository<Laboratory, Integer>, JpaSpecificationExecutor<LaboratorySeat> {


}
