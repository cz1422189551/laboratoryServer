package com.lq.laboratory.services;

import com.lq.laboratory.entity.Comment;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.services.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> {

    @Resource(name = "commentRepository")
    @Override
    public void setRepository(BaseRepository<Comment, Integer> repository) {
        super.setRepository(repository);
    }
}
