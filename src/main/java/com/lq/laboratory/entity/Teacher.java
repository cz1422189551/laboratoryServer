package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data

@NoArgsConstructor
@Entity
public class Teacher extends User {
//    //职称
//    private String title;
//
//    private String department;
//
//    public Teacher(int id, String userName, String password, String name, String tel, int gender, int userType, String title, String department) {
//        super(id, userName, password, name, tel, gender, userType);
//        this.title = title;
//        this.department = department;
//    }
}
