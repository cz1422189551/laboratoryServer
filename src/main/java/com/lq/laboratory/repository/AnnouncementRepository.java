package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Announcement;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Date;

public interface AnnouncementRepository extends BaseRepository<Announcement, Integer> {

    @Modifying
    @Query("update Announcement an set an.title=?2 ,an.content=?3,an.pushMan=?4,an.pushDate=?5 where an.id=?1")
    int update(@Param("id") int id, @Param("title") String title
            , @Param("content") String content, @Param("pushMan") String pushMan, @Param("pushDate") Date pushDate);

}
