package com.lq.laboratory.services;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.exception.UserExpcetion;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.UserRepository;
import com.lq.laboratory.services.base.UserService;
import com.lq.laboratory.util.DeleteUtil;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.STUDENT;

@Service
public class UserServiceImpl extends UserService {


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
        try {
            res = userRepository.saveAndFlush(user);
        } catch (RuntimeException e) {
            throw new UserExpcetion("账号已被注册");
        }

        return res;
    }

    @Override
    public boolean delete(String id) {
        User one = getOne(id);
        List<Laboratory> userLaboratoryList = one.getLaboratoryList();

        DeleteUtil.releaseLaboratory(userLaboratoryList);
        //自己的
        one.getCommentList().stream().forEach(comment -> {
            comment.setUser(null);
            comment.setLaboratory(null);
        });

        one.getAppointmentList().stream().forEach(ap -> {
            ap.setLaboratory(null);
            ap.setUser(null);
        });


        one.getLaboratoryList().clear();
        one.getCommentList().clear();
        one.getAppointmentList().clear();

        userRepository.delete(one);
        return true;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public User updateEntity(User user) {
        User one = getOne(user.getId() + "");
        user.setCommentList(one.getCommentList());
        user.setAppointmentList(one.getAppointmentList());
        user.setLaboratoryList(one.getLaboratoryList());
        return userRepository.saveAndFlush(user);
    }


    @Override
    public Map<Integer, List<User>> getGroupUser() {
        return null;
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
