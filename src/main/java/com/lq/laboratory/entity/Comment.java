package com.lq.laboratory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor

@NoArgsConstructor

@Entity
@Data
public class Comment extends BaseEntity  {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "laboratoryId")
    private Laboratory laboratory;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")

    private User user;


//    //自关联
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fathCommentId")
//    @JsonBackReference
//    private Comment parentComment;


    //评论内容
    private String commentContent;


//    @OneToMany(
//            cascade = CascadeType.ALL
//            , mappedBy = "parentComment"
//            , fetch = FetchType.EAGER
//    )
//    @Fetch(FetchMode.SUBSELECT)
//    @JsonIgnoreProperties(value = {"laboratory", "parentComment"})
//    //改评论的回复
//    private List<Comment> subComment = new ArrayList<>();


    //评论时间

    private Date time;


}