package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Comment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecifition extends BaseSpecification<Comment> {

    public static Specification<Comment> findByUser(int userId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("user").get("id"), userId));
    }
    public static Specification<Comment> findByLaboratry(int laboratoryId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("laboratory").get("id"), laboratoryId));
    }


}
