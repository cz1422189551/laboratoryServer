package com.lq.laboratory.services;

import com.lq.laboratory.entity.Announcement;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.AnnouncementRepository;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements IService<Announcement> {
    @Autowired
    AnnouncementRepository repository;

    @Override
    public Announcement getOne(String id) {
        return repository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public Result<Announcement> getList(int pageNumber, int pageSize) {
        Page<Announcement> page = repository.findAll(EntityFactory.createPagable(pageNumber, pageSize));
        return EntityFactory.createResult(page);
    }

    @Override
    public List<Announcement> getAll() {
        return repository.findAll();
    }



    @Override
    public Announcement insert(Announcement announcement) {
        return repository.saveAndFlush(announcement);
    }

    @Transactional
    @Override
    public int update( Announcement announcement) {
        return repository.update(announcement.getId(), announcement.getTitle(), announcement.getContent(), announcement.getPushMan(), announcement.getPushDate());
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(Integer.valueOf(id));
        return true;
    }

    @Override
    public boolean clear() {
        return false;
    }
}
