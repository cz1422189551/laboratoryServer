//package com.lq.laboratory.controller;
//
//import com.lq.laboratory.entity.ResponseEntity;
//import com.lq.laboratory.entity.Seat;
//import com.lq.laboratory.services.SeatServiceImpl;
//
//import com.lq.laboratory.util.EntityFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/seat")
//public class SeatController {
//    @Autowired
//    SeatServiceImpl seatService;
//
//    @RequestMapping(value = "/add")
//    public ResponseEntity add(Seat seat) {
//
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                Seat seat1 = new Seat(i,j);
//                EntityFactory.createResponse(seatService.insert(seat1));
//            }
//        }
//
//        return EntityFactory.createResponse(seatService.insert(seat));
//    }
//
//    @RequestMapping(value = "/one/{id}")
//    public ResponseEntity getOne(@PathVariable("id") String id) {
//        Seat one = seatService.getOne(id);
//        return EntityFactory.createResponse(one);
//    }
//}
