package com.lq.laboratory.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testStudent () {
        studentRepository.findById(1);
    }

}
