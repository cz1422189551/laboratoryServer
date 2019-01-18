package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Announcement;
import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class AnnouncementSpecification extends BaseSpecification<Announcement> {

    public static Specification<Announcement> findByPredicate(Map<String, Object> map) {
        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (map != null) {
                Date date = mapObjectToDate(map, "pushDate");
                String pushMan = (String) map.get("pushMan");
                String title = (String) map.get("title");
                if (!StringUtils.isEmpty(title)) {     //标题模糊匹配
                    String likeTitle = "%" + title + "%";
                    predicateList.add(cb.like(root.get("title"), likeTitle));
                }
                if (!StringUtils.isEmpty(pushMan)) {     //发布人模糊匹配
                    String likePushMan = "%" + pushMan + "%";
                    predicateList.add(cb.like(root.get("pushMan"), likePushMan));
                }
                if (date != null) {     //发布人模糊匹配
                    predicateList.add(cb.equal(root.get("date"), date));
                }
            }
            Predicate[] pre = new Predicate[predicateList.size()];
            return query.where(predicateList.toArray(pre)).getRestriction();
        };
    }

}
