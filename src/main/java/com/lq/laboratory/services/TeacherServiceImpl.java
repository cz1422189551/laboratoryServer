package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Teacher;
import com.lq.laboratory.repository.TeacherRepository;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class TeacherServiceImpl implements IService<Teacher> {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher getOne(String id) {
        return teacherRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public Result<Teacher> getList(int pageNumber, int pageSize) {
        Page<Teacher> page = teacherRepository.findAll(EntityFactory.createPagable(pageNumber, pageSize));
        return EntityFactory.createResult(page);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Result<Teacher> getCustom(String sql) {
        return null;
    }

    @Override
    public Teacher getCustomOne(String sql) {
        return null;
    }

    @Override
    public Teacher insert(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return null;
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
