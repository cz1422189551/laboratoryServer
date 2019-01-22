package com.lq.laboratory.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Comment extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "laboratoryId")
    private Laboratory laboratory;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date time;


}