//package com.lq.laboratory.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
///**
// * 实验室里的每一个座位
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "laboratory_seat")
//public class LaboratorySeat extends BaseEntity {
//
//
//    //状态是否被占用， -1 未启用 0 空位 1被占用
//    @Column(insertable = false, columnDefinition = "int default 0")
//    private Integer stateType;
//
//    @Column
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date appointmentDate;
//
//
//    @ManyToOne
//    @JoinColumn(name = "laboratory_id")
//    @JsonIgnore
//    private Laboratory laboratory;
//
//
//    @ManyToOne
//    @JoinColumn(name = "seat_id")
//    private Seat seat;
//
//}
