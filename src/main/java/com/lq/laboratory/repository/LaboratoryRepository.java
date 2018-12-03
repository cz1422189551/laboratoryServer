package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer>, JpaSpecificationExecutor<Laboratory> {


}
