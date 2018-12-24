package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Appointment;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import java.util.Date;

public class StatisticsSpecification extends BaseSpecification<Appointment> {

    //每个月的数量（加上取消的）
    public static Specification<Appointment> findByMonthCount(Date date) {
        return ((root, q, cb) -> {
            Expression<Long> count = cb.count(root);
            CriteriaQuery<Object> query = cb.createQuery();
            query.multiselect(count);
            query.where(
                    cb.equal(root.get("date"), date)
            );
//
            return null;
        });
    }

}
