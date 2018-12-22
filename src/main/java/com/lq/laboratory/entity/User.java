package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = @UniqueConstraint(name = "uni_name", columnNames = "userName"))
public class User extends BaseEntity {

    protected String name;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String name, String userName, String password, String tel, int gender, int userType) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.gender = gender;
        this.userType = userType;

    }

    protected String userName;

    protected String password;


    protected String tel;

    protected int gender;

    //用户类别（学生，或教师）
    protected int userType;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> commentList;


}
