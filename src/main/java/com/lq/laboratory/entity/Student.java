package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User {


    private String address;

    //班级
    private String classGrade;

    //学院
    private String department;



    public Student(int id, String userName, String password, String nickName, String tel, int gender, int userType, String address, String classGrade, String department) {
        super(id, userName, password, nickName, tel, gender, userType);
        this.address = address;
        this.classGrade = classGrade;
        this.department = department;
    }
}
