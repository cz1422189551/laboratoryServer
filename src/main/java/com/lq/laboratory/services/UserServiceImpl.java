package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Student;
import com.lq.laboratory.entity.Teacher;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.repository.StudentRepository;
import com.lq.laboratory.repository.TeacherRepository;
import com.lq.laboratory.repository.UserRepository;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.lq.laboratory.services.Const.STUDENT;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Result<User> getCustom(String sql) {
        return null;
    }

    @Override
    public User getCustomOne(String sql) {
        return null;
    }

    @Override
    public User insert(User user) {

        if (user == null || user.getId() == 0) throw new RuntimeException("插入对象为null");

        return user.getUserType() == STUDENT
                ? studentService.insert((Student) user)
                : teacherService.insert((Teacher) user);
    }

    @Override
    public User update(User user) {
        if (user == null || user.getId() == 0) throw new RuntimeException("更新对象为null");

        return user.getUserType() == STUDENT
                ? studentService.update((Student) user)
                : teacherService.update((Teacher) user);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }


    @Override
    public Map<Integer, List<User>> getGroupUser() {
        return null;
    }

    @Deprecated
    @Override
    public User getOne(String id) {
        User user = null;
        user = teacherService.getOne(id) != null ? teacherService.getOne(id) : studentService.getOne(id);
        return user;
    }


    @Override
    public Result<User> getList(int pageNumber, int pageSize) {
        Page<User> page = userRepository.findAll(EntityFactory.createPagable(pageNumber, pageSize));
        return EntityFactory.createResult(page);
    }
}
