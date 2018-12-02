package com.lq.laboratory.util;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.User;
import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JsonUtilsTest {


    @Test
    public void testFromJsonToOneEntity() {
        User expected = new User("admin", "admin");
        ResponseEntity<User> target = new ResponseEntity<>(1, "msg", expected);
        String json = JsonUtils.toJson(target);
        ResponseEntity entity = (ResponseEntity) JsonUtils.fromJson(json, ResponseEntity.class, User.class);
        User actual = (User) entity.getData();
        Assert.assertEquals(expected.getUserName(), actual.getUserName());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
    }

    @Test
    public void testFromJsonToListEntity() {
        User[] arr = {new User("1", "1"), new User("2", "2"), new User("3", "3")};
        List<User> expected = Arrays.asList(arr);
        ResponseEntity<List<User>> target = new ResponseEntity<>(1, "msg", expected);

        String json = JsonUtils.toJson(target);

        Object o = JsonUtils.fromJson(json, ResponseEntity.class, new Class[]{List.class, User.class});

        ResponseEntity entity = (ResponseEntity) o;
        List<User> actual = (List<User>) entity.getData();
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expected.get(i).getUserName(), actual.get(i).getUserName());
            Assert.assertEquals(expected.get(i).getPassword(), actual.get(i).getPassword());

        }
    }

    @Test
    public void testFromJsonToEntityIncludeList() {
        User[] arr = {new User("1", "1"), new User("2", "2"), new User("3", "3")};
        List<User> list = Arrays.asList(arr);
        Result<User> expected = new Result<>(10, 1, 100, 10, 10, list);

        ResponseEntity<Result<User>> target = new ResponseEntity<>(1, "msg", expected);

        String json = JsonUtils.toJson(target);

        ResponseEntity<Result<User>> entity = (ResponseEntity<Result<User>>) JsonUtils.fromJson(json, ResponseEntity.class, new Class[]{Result.class, User.class});
        Result<User> actual = entity.getData();
        Assert.assertEquals(expected.getPageSize(), actual.getPageSize());
        for (int i = 0; i < actual.getResult().size(); i++) {

            Assert.assertEquals(expected.getResult().get(i).getUserName(), actual.getResult().get(i).getUserName());
            Assert.assertEquals(expected.getResult().get(i).getPassword(), actual.getResult().get(i).getPassword());

        }
        System.out.println("");
    }


}