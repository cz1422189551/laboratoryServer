package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Student;

import static com.lq.laboratory.util.EntityFactory.*;

import com.lq.laboratory.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> {

    @Resource(name = "studentRepository")
    @Override
    public void setRepository(BaseRepository<Student, Integer> repository) {
        super.setRepository(repository);
    }

    @Transactional
    @Override
    public int update(Student student) {
        return 0;
    }
}
