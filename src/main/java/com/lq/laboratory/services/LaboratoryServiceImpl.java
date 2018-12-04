package com.lq.laboratory.services;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LaboratoryServiceImpl extends BaseServiceImpl<Laboratory> {

    @Resource(name = "laboratoryRepository")
    @Override
    public void setRepository(BaseRepository<Laboratory, Integer> repository) {
        super.setRepository(repository);
    }

    @Transactional
    @Override
    public int update(Laboratory laboratory) {
        return 0;
    }
}
