package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Student;
import com.lq.laboratory.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
