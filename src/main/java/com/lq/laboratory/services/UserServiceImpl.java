package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Student;
import com.lq.laboratory.entity.Teacher;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.exception.UserExpcetion;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.UserRepository;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.Const.TEACHER;

@Service
public class UserServiceImpl extends UserService {


    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    UserRepository userRepository;

    @Resource(name = "userRepository")
    @Override
    public void setRepository(BaseRepository<User, Integer> repository) {
        super.setRepository(repository);
        userRepository = (UserRepository) repository;
    }

    @Transactional
    @Override
    public User insert(User user) {
        User res = null;
        if (user == null) throw new UserExpcetion("不能添加空值");
//        User byUserName = userRepository.findByUserName(user.getUserName());
//        if (byUserName != null && !"".equals(byUserName.getUserName())) throw new UserExpcetion("该账号已被注册");
        try {
            if (user.getUserType() == STUDENT) {
                res = studentService.insert((Student) user);
            } else if (user.getUserType() == TEACHER) {
                res = teacherService.insert((Teacher) user);
            }
        } catch (RuntimeException e) {
            throw new UserExpcetion("账号已被注册");
        }

        return res;
    }

    @Transactional
    @Override
    public int update(User user) {
        if (user == null || user.getId() == 0) throw new RuntimeException("更新对象为null");

        return user.getUserType() == STUDENT
                ? studentService.update((Student) user)
                : teacherService.update((Teacher) user);
    }

//    @Transactional
//    @Override
//    public boolean delete(String id) {
//        userRepository.deleteById(Integer.valueOf(id));
//        return true;
//    }

    @Override
    public boolean clear() {
        return false;
    }


    @Override
    public Map<Integer, List<User>> getGroupUser() {
        return null;
    }


    @Override
    public User getOne(String id) {
        User user = null;
        user = teacherService.getOne(id) != null ? teacherService.getOne(id) : studentService.getOne(id);
        return user;
    }


    @Override
    public Result<User> getList(int pageNumber, int pageSize) {
        Page<User> page = userRepository.findAll(EntityFactory.createPageable(pageNumber, pageSize));
        return EntityFactory.createResult(page);
    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {

        return userRepository.findUserByUserNameAndPassword(userName, password);
    }
}
