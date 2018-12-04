package com.lq.laboratory.services;

import com.lq.laboratory.entity.Student;

import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
