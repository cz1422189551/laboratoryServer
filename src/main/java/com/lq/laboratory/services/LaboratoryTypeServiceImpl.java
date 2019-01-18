package com.lq.laboratory.services;

import com.lq.laboratory.entity.LaboratoryType;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LaboratoryTypeServiceImpl extends BaseServiceImpl<LaboratoryType> {

    @Resource(name = "laboratoryTypeRepository")
    @Override
    public void setRepository(BaseRepository<LaboratoryType, Integer> repository) {
        super.setRepository(repository);
    }



}
