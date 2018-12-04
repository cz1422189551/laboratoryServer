package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.repository.specifi.LaboratorySeatSpecification;
import com.lq.laboratory.repository.specifi.SeatSpecification;
import com.lq.laboratory.services.LaboratorySeatServiceImpl;
import com.lq.laboratory.services.LaboratoryServiceImpl;
import com.lq.laboratory.services.SeatServiceImpl;
import com.lq.laboratory.services.UserServiceImpl;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    LaboratoryServiceImpl laboratoryService;

    @Autowired
    LaboratorySeatServiceImpl laboratorySeatService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    SeatServiceImpl seatService;


    @RequestMapping(value = "/add")
    public ResponseEntity add(Laboratory laboratory) {

        laboratory.setUser(userService.getOne(1 + ""));
        laboratory.setCloseDate(new Date());
        laboratory.setOpenDate(new Date());
        laboratory.setRow(5);
        laboratory.setCol(5);
        laboratory.setEnable(true);

        List<Seat> seatList = seatService.getAll(SeatSpecification.getSeatList(5, 5));

        laboratory.setSeatList(seatList);

        return EntityFactory.createResponse(laboratoryService.insert(laboratory));
    }

    //更新实验室信息
    @RequestMapping(value = "/update")
    public ResponseEntity updateInfo(Laboratory laboratory) {

        laboratory.setUser(userService.getOne(1 + ""));
        laboratory.setCloseDate(new Date());
        laboratory.setOpenDate(new Date());
        laboratory.setRow(2);
        laboratory.setCol(2);
        laboratory.setEnable(true);
        laboratory.setId(1);
        List<Seat> seatList = seatService.getAll(SeatSpecification.getSeatList(laboratory.getRow(), laboratory.getCol()));

        laboratory.setSeatList(seatList);

        return EntityFactory.createResponse(laboratoryService.update(laboratory));
    }


    @RequestMapping(value = "/seat/update", method = RequestMethod.POST)
    public ResponseEntity update(Laboratory laboratory) {

//        Laboratory one = laboratoryService.getOne(1 + "");
        List<LaboratorySeat> all = laboratorySeatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(laboratory.getId()));

        return null;
//        return EntityFactory.createResponse(laboratoryService.insert(laboratory));
    }

    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/seat/one/{id}", method = RequestMethod.GET)
    public ResponseEntity update(@PathVariable("id") String id) {

        List<LaboratorySeat> list = laboratorySeatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(Integer.valueOf(id)));

        System.out.println("");
        return null;

    }

}
