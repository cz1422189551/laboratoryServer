package com.lq.laboratory.controller;

import com.lq.laboratory.entity.*;

import com.lq.laboratory.repository.LaboratoryRepository;
import com.lq.laboratory.repository.specifi.LaboratorySpecification;
import com.lq.laboratory.services.*;
import com.lq.laboratory.util.DeleteUtil;
import com.lq.laboratory.util.EntityFactory;
import com.lq.laboratory.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.lq.laboratory.util.Const.STUDENT;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    LaboratoryServiceImpl laboratoryService;


    @Autowired
    UserServiceImpl userService;

    @Autowired
    LaboratoryRepository laboratoryRepository;


    @Autowired
    LaboratoryTypeServiceImpl laboratoryTypeService;


    //类别删除
    @RequestMapping(value = "/type/admin/delete", method = RequestMethod.POST)
    public ResponseEntity delete(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        LaboratoryType type = laboratoryTypeService.getOne(id);
        DeleteUtil.deleteLaboratoryType(type);
        laboratoryTypeService.delete(type);
        return EntityFactory.createResponse(true);
    }

    //类别新增
    @RequestMapping(value = "/type/admin/add")
    public ResponseEntity addType(@RequestBody LaboratoryType laboratoryType) {
        if (laboratoryType == null || StringUtils.isEmpty(laboratoryType.getName()))
            throw new RuntimeException("名称不能为null");
        LaboratoryType insert = laboratoryTypeService.insert(laboratoryType);
        return EntityFactory.createResponse(insert);
    }

    //类别更新
    @RequestMapping(value = "/type/admin/update", method = RequestMethod.POST)
    public ResponseEntity adminUpdate(@RequestBody LaboratoryType laboratoryType) throws UnsupportedEncodingException {
        LaboratoryType type = laboratoryTypeService.updateEntity(laboratoryType);
        return EntityFactory.createResponse(type);
    }

    //类别查询
    @RequestMapping(value = "/type/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity searchType(@RequestBody Map<String, Object> map) throws ParseException {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");
        Page<LaboratoryType> page = laboratoryTypeService.getList(
                LaboratorySpecification.findByPredicate((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }

    //实验室查询
    @RequestMapping(value = "/admin/getList/search", method = RequestMethod.POST)
    public ResponseEntity searchLaboratory(@RequestBody Map<String, Object> map) throws ParseException {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");
        Page<Laboratory> page = laboratoryService.getList(
                LaboratorySpecification.findByPredicateLaboratory((Map<String, Object>) map.get("map")), pageNum, pageSize
        );
        Result result = EntityFactory.createResult(page);
        return EntityFactory.createResponse(result);
    }

    //实验室新增
    @RequestMapping(value = "/admin/add")
    public ResponseEntity add(@RequestBody Laboratory laboratory) {
        if (laboratory == null || laboratory.getSeatCount() < 1) throw new RuntimeException("检查新增实验室信息");
        laboratory.setOpenDate(new Date());
        Laboratory insert = laboratoryService.insert(laboratory);
        return EntityFactory.createResponse(insert);
    }

    //更新实验室
    @RequestMapping(value = "/admin/update")
    public ResponseEntity updateInfo(@RequestBody Laboratory laboratory) {
        if (laboratory == null || laboratory.getSeatCount() < 1) throw new RuntimeException("检查提交的实验室信息");
        laboratory.setOpenDate(new Date());
        int update = laboratoryService.update(laboratory);
        return EntityFactory.createResponse(update);
    }

    //实验室删除
    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseEntity deleteLab(@RequestBody Map<String, String> map) {
        String id = map.get("id");

        Laboratory laboratory = laboratoryService.getOne(id);

        DeleteUtil.deleteLaboratory(laboratory);

        LaboratoryType type = laboratory.getLaboratoryType();
        type.getLaboratoryList().remove(laboratory);
        laboratory.setLaboratoryType(null);
        laboratoryService.delete(laboratory);
        return EntityFactory.createResponse("ok");
    }


    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/getList")
    public Result update(@RequestParam Map<String, String> map) {

        int pageNum = FormatUtil.getPageAfterRemove(map, "pageNum");
        int pageSize = FormatUtil.getPageAfterRemove(map, "pageSize");
        Result result = laboratoryService.getList(pageNum, pageSize);
        return result;
    }


    //查看一个实验室包含座位的信息
    @RequestMapping(value = "/type/getAll")
    public List<LaboratoryType> queryAll(@RequestParam Map<String, String> map) {
        List<LaboratoryType> all = null;
        if (map == null || map.get("userType") == null || "".equals(map.get("userType"))) {
            all = laboratoryTypeService.getAll();
        } else {
            all = laboratoryTypeService.getAll();
            all.stream()
                    .forEach(
                            t ->
                                    t.setLaboratoryList(
                                            t.getLaboratoryList()
                                                    .stream()
                                                    .filter(l -> l.getAvailableType() == STUDENT)
                                                    .collect(Collectors.toList())
                                    )
                    );

        }

        return all;
    }

    @RequestMapping(value = "/admin/type/getAll")
    public ResponseEntity adminQueryAll(@RequestParam Map<String, String> map) {
        return EntityFactory.createResponse(queryAll(map));
    }

    //构造级联关系
    @RequestMapping(value = "/admin/type/cascade")
    public List<Map<String, Object>> adminQueryCascade() {
        List<LaboratoryType> all = laboratoryTypeService.getAll();
        List<Map<String, Object>> result = new ArrayList<>();
        all.stream().forEach(
                l -> {
                    String label = l.getName();
                    int value = l.getId();
                    Map<String, Object> map = new HashMap<>();
                    map.put("label", label);
                    map.put("value", value + "_");
                    List<Map<String, Object>> childrenList = l.getLaboratoryList().stream().map(lb -> {
                        Map<String, Object> childrenMap = new HashMap<>();
                        childrenMap.put("label", lb.getName());
                        childrenMap.put("value", lb.getId());
                        childrenMap.put("available", lb.getAvailableType());
                        childrenMap.put("seatCount", lb.getSeatCount());
                        childrenMap.put("children", null);
                        return childrenMap;
                    }).collect(Collectors.toList());
                    map.put("children", childrenList);
                    result.add(map);
                }
        );
        return result;
    }


}
