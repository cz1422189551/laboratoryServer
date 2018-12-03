package com.lq.laboratory.services;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements IService<Laboratory> {

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Override
    public Laboratory getOne(String id) {
        return null;
    }

    @Override
    public Result<Laboratory> getList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<Laboratory> getAll() {
        return null;
    }

    @Override
    public Laboratory insert(Laboratory laboratory) {

        return laboratoryRepository.save(laboratory);
    }

    @Override
    public int update(Laboratory laboratory) {
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
}
