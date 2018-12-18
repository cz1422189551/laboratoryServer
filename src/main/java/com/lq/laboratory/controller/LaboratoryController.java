package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;

import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.services.*;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    LaboratoryServiceImpl laboratoryService;

//    @Autowired
//    LaboratorySeatServiceImpl laboratorySeatService;

    @Autowired
    UserServiceImpl userService;



    @Autowired
    LaboratoryTypeServiceImpl laboratoryTypeService;


    @RequestMapping(value = "/add")
    public ResponseEntity add(Laboratory laboratory) {

        laboratory.setUser(userService.getOne(1 + ""));
        laboratory.setCloseDate(new Date());
        laboratory.setOpenDate(new Date());
        laboratory.setRow(5);
        laboratory.setCol(5);
        laboratory.setEnable(true);

//        List<Seat> seatList = seatService.getAll(SeatSpecification.getSeatList(5, 5));
//
//        laboratory.setSeatList(seatList);

        return EntityFactory.createResponse(laboratoryService.insert(laboratory));
    }

    //更新实验室信息
    @RequestMapping(value = "/update")
    public ResponseEntity updateInfo(Laboratory laboratory) {

        laboratory.setUser(userService.getOne(1 + ""));
        laboratory.setCloseDate(new Date());
        laboratory.setOpenDate(new Date());
        laboratory.setRow(5);
        laboratory.setCol(5);
        laboratory.setEnable(true);
        laboratory.setId(2);
        laboratory.setName("实验室" + laboratory.getId());
        LaboratoryType type = new LaboratoryType();
        type.setId(2);
        laboratory.setLaboratoryType(type);
//        List<Seat> seatList = seatService.getAll(SeatSpecification.getSeatList(laboratory.getRow(), laboratory.getCol()));

//        laboratory.setSeatList(seatList);

        return EntityFactory.createResponse(laboratoryService.update(laboratory));
    }


//    @RequestMapping(value = "/seat/update", method = RequestMethod.POST)
//    public ResponseEntity update(Laboratory laboratory) {
//
//        Map<Laboratory, List<LaboratorySeat>> collect = new HashMap<>();
//
//
//        return EntityFactory.createResponse(laboratoryService.insert(laboratory));
//    }

//    //查看一个实验室包含座位的信息
//    @RequestMapping(value = "/seat/one/{id}", method = RequestMethod.GET)
//    public Map getLaboratorySeat(@PathVariable("id") String id) {
//
//        List<LaboratorySeat> list = laboratorySeatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(Integer.valueOf(id)));
//        Map<Laboratory, List<LaboratorySeat>> collect = new HashMap<>();
//        collect.put(list.get(0).getLaboratory(), list);
//        return collect;
//    }

    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/getList")
    public ResponseEntity update(@RequestParam Map<String, String> map) {

        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = laboratoryService.getList(BaseSpecification.<Laboratory>findByAnd(map), pageNum, pageSize);
        return EntityFactory.createResponse(EntityFactory.createResult(page));
    }

    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/type/getAll")
    public List<LaboratoryType> queryAll() {
        List<LaboratoryType> all = laboratoryTypeService.getAll();

        return all;
    }

//    //查看一个实验室包含座位的信息
//    @RequestMapping(value = "/type/getAll")
//    public List<LaboratoryTypeEntity> queryAll() {
//        List<LaboratoryType> all = laboratoryTypeService.getAll();
//
//        return EntityFactory.createLaboratoryTypeEntity(all, laboratorySeatService);
//    }
//
//    @RequestMapping(value = "/type/id}")
//    public LaboratoryTypeEntity queryAll(@PathVariable("id") String id) {
//        LaboratoryType type = laboratoryTypeService.getOne(id);
//
//        return EntityFactory.createLaboratoryTypeEntity(type, laboratorySeatService);
//    }


}
