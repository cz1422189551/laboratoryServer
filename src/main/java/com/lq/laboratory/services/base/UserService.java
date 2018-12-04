package com.lq.laboratory.services.base;

import com.lq.laboratory.entity.User;
import com.lq.laboratory.repository.BaseRepository;

import java.util.List;
import java.util.Map;

public abstract class UserService extends BaseServiceImpl<User> {

    //分组
    public abstract Map<Integer, List<User>> getGroupUser();

   public abstract User getUserByUserNameAndPassword(String userName, String password);

}
