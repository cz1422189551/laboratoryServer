package com.lq.laboratory.services;

import com.lq.laboratory.entity.Teacher;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> {


    @Resource(name="teacherRepository")
    @Override
    public void setRepository(BaseRepository<Teacher, Integer> repository) {
        super.setRepository(repository);
    }

    @Transactional
    @Override
    public int update(Teacher teacher) {
        return 0;
    }
}
