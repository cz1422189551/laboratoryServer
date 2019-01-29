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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="laboratoryId")
    private Laboratory laboratory;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="userId")
    private User user;


    //评论内容
    private String commentContent;

    //评论时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date time;


}