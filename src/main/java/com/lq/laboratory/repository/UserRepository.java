package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Student;
import com.lq.laboratory.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

public interface UserRepository extends BaseRepository<User, Integer> {

    User findUserByUserNameAndPassword(@Param("username") String userName, @Param("password") String password);

}
