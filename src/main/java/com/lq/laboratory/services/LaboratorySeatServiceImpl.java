package com.lq.laboratory.services;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.LaboratorySeat;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.LaboratoryRepository;
import com.lq.laboratory.repository.LaboratorySeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorySeatServiceImpl implements IService<LaboratorySeat> {

    @Autowired
    LaboratorySeatRepository laboratorySeatRepository;


    @Override
    public LaboratorySeat getOne(String id) {
        return null;
    }

    @Override
    public Result<LaboratorySeat> getList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<LaboratorySeat> getAll() {
        return null;
    }

    @Override
    public LaboratorySeat insert(LaboratorySeat laboratorySeat) {
        return null;
    }

    @Override
    public int update(LaboratorySeat laboratorySeat) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public Page<LaboratorySeat> getList(Specification<LaboratorySeat> specification, int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<LaboratorySeat> getAll(Specification<LaboratorySeat> specification) {

        return laboratorySeatRepository.findAll(specification);
    }
}
