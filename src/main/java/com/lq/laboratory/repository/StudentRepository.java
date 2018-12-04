package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends BaseRepository<Student, Integer> {

}
