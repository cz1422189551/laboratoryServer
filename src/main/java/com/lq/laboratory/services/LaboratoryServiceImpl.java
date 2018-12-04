package com.lq.laboratory.services;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LaboratoryServiceImpl extends BaseServiceImpl<Laboratory> {

    @Resource(name = "laboratoryRepository")
    @Override
    public void setRepository(BaseRepository<Laboratory, Integer> repository) {
        super.setRepository(repository);
    }

//    @Transactional
//    @Override
//    public int update(Laboratory laboratory) {
////        Laboratory one = getOne(laboratory.getId() + "");
////        if (one == null) return 0;
//        return repository.saveAndFlush(laboratory) == null ? 0 : 1;
//    }
}
