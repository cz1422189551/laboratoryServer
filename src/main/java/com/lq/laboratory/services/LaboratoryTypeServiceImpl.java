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


    @Override
    public LaboratoryType updateEntity(LaboratoryType laboratoryType) {
        LaboratoryType one = getOne(laboratoryType.getId() + "");
        if (one == null) throw new RuntimeException("没有这个类型了");
        one.setName(laboratoryType.getName());
        return repository.saveAndFlush(one);
    }
}
