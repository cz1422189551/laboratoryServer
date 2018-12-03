package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeatRepository extends JpaRepository<Seat, Integer>,JpaSpecificationExecutor<Seat> {

}
