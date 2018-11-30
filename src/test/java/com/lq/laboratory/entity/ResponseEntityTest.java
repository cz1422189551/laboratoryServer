package com.lq.laboratory.entity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.json.GsonFactoryBean;

import static org.junit.Assert.*;

public class ResponseEntityTest {

    ResponseEntity<User> target;

    @Before
    public void setUp() {
        target = new ResponseEntity<>();
    }

    @Test
    public void testResponseOneData() {
        User user = new User("admin", "admin");
        target.setData(user);

    }


    @Test
    public void testResponseEntity() {
        User user = new User("a", "1");
        User user2 = new User("b", "2");
        User user3 = new User("c", "3");
        User user4 = new User("d", "4");

    }

}