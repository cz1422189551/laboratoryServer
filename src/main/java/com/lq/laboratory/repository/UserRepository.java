package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Student;
import com.lq.laboratory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
