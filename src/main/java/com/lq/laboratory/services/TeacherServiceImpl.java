package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Teacher;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.TeacherRepository;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl extends  BaseServiceImpl<Teacher> {


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
