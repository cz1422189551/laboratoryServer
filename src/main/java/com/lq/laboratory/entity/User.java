package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class User {

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String userName;

    protected String password;

    protected String name;

    protected String tel;

    protected boolean gender;

    //用户类别（学生，或教师）
    protected int userType;

    protected Date createTime;


}
