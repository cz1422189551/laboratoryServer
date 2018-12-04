package com.lq.laboratory.services;

import com.lq.laboratory.entity.Announcement;
import com.lq.laboratory.repository.AnnouncementRepository;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> {


    @Resource(name = "announcementRepository")
    @Override
    public void setRepository(BaseRepository<Announcement, Integer> repository) {
        super.setRepository(repository);
    }

    @Transactional
    @Override
    public int update(Announcement announcement) {
        AnnouncementRepository announcementRepository = (AnnouncementRepository) repository;
        return announcementRepository.update(announcement.getId(), announcement.getTitle(), announcement.getContent(), announcement.getPushMan(), announcement.getPushDate());
    }
}
