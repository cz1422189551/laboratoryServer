//package com.lq.laboratory.repository;
//
//import com.lq.laboratory.entity.Student;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//@DataJpaTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Student.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class StudentRepositoryTest extends BaseRepositoryTest {
//
//    @Autowired
//    StudentRepository repository;
//
//    @Test
//    public void testGetOne() {
//        Student one = repository.getOne(-1);
//        Assert.assertEquals(null, one);
//    }
//
//}