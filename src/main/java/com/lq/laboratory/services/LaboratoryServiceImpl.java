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

    @Override
    public Laboratory updateEntity(Laboratory laboratory) {
        Laboratory one = getOne(laboratory.getId() + "");
        laboratory.setAppointmentList(one.getAppointmentList());
        laboratory.setCommentList(one.getCommentList());
        laboratory.setUser(one.getUser());
        return repository.saveAndFlush(laboratory);
    }
}
