package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.entity.Comment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.All;

public class CommentSpecifition extends BaseSpecification<Comment> {

    public static Specification<Comment> findByUser(int userId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("user").get("id"), userId));
    }

    public static Specification<Comment> findByLaboratry(int laboratoryId) {
        return (root, query, cb) -> cb.and(cb.equal(root.get("laboratory").get("id"), laboratoryId));
    }

    public static Specification<Comment> findByPredicate(Map<String, Object> map) {
        return ((root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (map != null) {


                String name = (String) map.get("name");
                String tel = (String) map.get("tel");

                Integer userType = mapObjectToInteger(map, "userType");
                //用户信息
                if (!StringUtils.isEmpty(name)) {     //姓名模糊匹配
                    String likeName = "%" + name + "%";
                    predicateList.add(cb.like(root.get("user").get("userName"), likeName));
                }
                if (!StringUtils.isEmpty(tel)) {     //电话模糊匹配
                    String likeTel = tel + "%";
                    predicateList.add(cb.like(root.get("user").get("tel"), likeTel));
                }
                if (!(userType == null)) {     //角色匹配
                    predicateList.add(cb.equal(root.get("user").get("userType"), userType));
                }
                //实验室信息
                Integer laboratoryType = mapObjectToInteger(map, "laboratoryType");
                String laboratoryName = (String) map.get("laboratoryName");
                if (!StringUtils.isEmpty(laboratoryName)) {     //实验室名称模糊匹配
                    String likeLaboratoryName = "%" + laboratoryName + "%";
                    predicateList.add(cb.like(root.get("laboratory").get("name"), likeLaboratoryName));
                }
                if (laboratoryType != null && laboratoryType != All) {     //实验室类型匹配
                    predicateList.add(cb.equal(root.get("laboratory").get("laboratoryType").get("id"), laboratoryType));
                }
                //留言信息

                String content = (String) map.get("content");

                if (!StringUtils.isEmpty(content)) {     //内容匹配
                    String likeContent = "%" + content + "%";
                    predicateList.add(cb.like(root.get("commentContent"), likeContent));
                }
                Date date = mapObjectToDate(map, "date");
                if (!(date == null)) {     //日期
                    predicateList.add(cb.equal(root.get("date"), date));
                }
            }

            Predicate[] pre = new Predicate[predicateList.size()];
            return query.where(predicateList.toArray(pre)).getRestriction();
        });
    }


}
