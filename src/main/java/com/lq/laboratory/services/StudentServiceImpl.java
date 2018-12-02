package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Student;
import com.lq.laboratory.repository.StudentRepository;
import com.lq.laboratory.util.EntityFactory;

import static com.lq.laboratory.util.EntityFactory.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IService<Student> {

    @Autowired
    JpaRepository<Student, Integer> studentRepository;

    @Override
    public Student getOne(String id) {
        return studentRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public Result<Student> getList(int pageNumber, int pageSize) {
        Page<Student> page = studentRepository.findAll(createPagable(pageNumber, pageSize));
        return createResult(page);
    }

    @Override
    public List<Student> getAll() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    @Override
    public Result<Student> getCustom(String sql) {
        return null;
    }

    @Override
    public Student getCustomOne(String sql) {
        return null;
    }

    @Override
    public Student insert(Student student) {
//        throw new RuntimeException("错误");
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }
}
