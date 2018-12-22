package com.lq.laboratory;

import com.lq.laboratory.entity.User;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaboratoryApplicationTests {

    @Autowired
    UserServiceImpl userService;



    @Test
    public void contextLoads() {
        List<User> all = userService.getAll();
        String s = JsonUtils.toJson(all);
    }

    @Test
    public void testDelete () {
        boolean delete = userService.delete(3 + "");

    }

}
