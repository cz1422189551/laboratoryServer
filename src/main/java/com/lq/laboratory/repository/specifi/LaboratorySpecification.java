package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Laboratory;
import com.lq.laboratory.entity.LaboratoryType;
import com.lq.laboratory.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.All;

public class LaboratorySpecification extends BaseSpecification<Laboratory> {

    public static Specification<LaboratoryType> findByPredicate(Map<String, Object> map) {
        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (map != null) {
                String name = (String) map.get("name");
                if (!StringUtils.isEmpty(name)) {     //类别名
                    String likeName = "%" + name + "%";
                    predicateList.add(cb.like(root.get("name"), likeName));
                }
            }
            Predicate[] pre = new Predicate[predicateList.size()];
            return query.where(predicateList.toArray(pre)).getRestriction();
        };
    }

    public static Specification<Laboratory> findByPredicateLaboratory(Map<String, Object> map) {
        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (map != null) {
                String address = (String) map.get("address");
                String name = (String) map.get("name");
                String description = (String) map.get("description");
                Integer seatCount = mapObjectToInteger(map, "seatCount");
                Integer enable = mapObjectToInteger(map, "enable");
                Integer availableType = mapObjectToInteger(map, "availableType");
                Integer laboratoryType = mapObjectToInteger(map, "laboratoryType");
                if (!StringUtils.isEmpty(name)) {     //名称
                    String likeName = "%" + name + "%";
                    predicateList.add(cb.like(root.get("name"), likeName));
                }
                if (!StringUtils.isEmpty(address)) {     //地址
                    String likeAddress = "%" + address + "%";
                    predicateList.add(cb.like(root.get("address"), likeAddress));
                }
                if (!StringUtils.isEmpty(description)) {     //电话
                    String likeDescription = "%" + description + "%";
                    predicateList.add(cb.like(root.get("description"), likeDescription));
                }
                if (seatCount != null && seatCount != All) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("seatCount"), seatCount));
                }
                if (enable != null && enable != All) {
                    predicateList.add(cb.equal(root.get("enable"), enable));
                }
                if (availableType != null && availableType != All) { //可用类型
                    predicateList.add(cb.equal(root.get("availableType"), availableType));
                }
                if (laboratoryType != null && laboratoryType != All) { //实验室类型
                    predicateList.add(cb.equal(root.get("laboratoryType").get("id"), laboratoryType));
                }
            }
            Predicate[] pre = new Predicate[predicateList.size()];
            return query.where(predicateList.toArray(pre)).getRestriction();
        };
    }
}
