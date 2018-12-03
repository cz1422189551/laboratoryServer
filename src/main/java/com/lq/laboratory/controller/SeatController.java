package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.Seat;
import com.lq.laboratory.services.SeatServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatServiceImpl seatService;

    @RequestMapping(value = "/add")
    public ResponseEntity add(Seat seat) {
        return EntityFactory.createResponse(seatService.insert(seat));
    }
}
