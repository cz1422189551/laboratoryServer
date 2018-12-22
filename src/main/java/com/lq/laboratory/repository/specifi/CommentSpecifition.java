package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Comment;
import org.springframework.data.jpa.domain.Specification;

public class CommentSpecifition extends BaseSpecification<Comment> {

    public static Specification<Comment> findByUser(int userId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("user").get("id"), userId));
    }
    public static Specification<Comment> findByLaboratry(int laboratoryId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("laboratory").get("id"), laboratoryId));
    }
}
