package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    //分组
    Map<Integer, List<User>> getGroupUser();

}
