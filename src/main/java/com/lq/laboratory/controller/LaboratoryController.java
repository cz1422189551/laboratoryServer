package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;
import com.lq.laboratory.repository.specifi.BaseSpecification;
import com.lq.laboratory.repository.specifi.LaboratorySeatSpecification;
import com.lq.laboratory.repository.specifi.SeatSpecification;
import com.lq.laboratory.repository.specifi.UserSpecification;
import com.lq.laboratory.services.LaboratorySeatServiceImpl;
import com.lq.laboratory.services.LaboratoryServiceImpl;
import com.lq.laboratory.services.SeatServiceImpl;
import com.lq.laboratory.services.UserServiceImpl;
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
    public Map update(Laboratory laboratory) {

        List<LaboratorySeat> all = laboratorySeatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(laboratory.getId()));

        Map<Laboratory, List<LaboratorySeat>> collect = new HashMap<>();
//        all.stream().map(k -> k)
        collect.put(all.get(0).getLaboratory(), null);
        return collect;
//        return EntityFactory.createResponse(laboratoryService.insert(laboratory));
    }

    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/seat/one/{id}", method = RequestMethod.GET)
    public List<LaboratorySeat> getLaboratorySeat(@PathVariable("id") String id) {

        List<LaboratorySeat> list = laboratorySeatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(Integer.valueOf(id)));

        return list;
    }

    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/getList")
    public ResponseEntity update(@RequestParam Map<String, String> map) {

        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Page page = laboratoryService.getList(BaseSpecification.<Laboratory>findByAnd(map), pageNum, pageSize);
        return EntityFactory.createResponse(EntityFactory.createResult(page));
    }

}
