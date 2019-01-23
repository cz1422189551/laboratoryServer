package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Announcement;
import com.lq.laboratory.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.lq.laboratory.util.Const.ADMIN;
import static com.lq.laboratory.util.Const.All;

public class UserSpecification extends BaseSpecification<User> {

    public static Specification<User> findByPredicate(Map<String, Object> map) {
        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (map != null) {
                String userName = (String) map.get("userName");
                String name = (String) map.get("name");
                String tel = (String) map.get("tel");
                String password = (String) map.get("password");
                Integer userType = mapObjectToInteger(map, "userType");
                Integer gender = mapObjectToInteger(map, "gender");

                if (!StringUtils.isEmpty(name)) {     //用户名
                    String likeName = "%" + name + "%";
                    predicateList.add(cb.like(root.get("name"), likeName));
                }
                if (!StringUtils.isEmpty(userName)) {     //姓名
                    String likeUserName = "%" + userName + "%";
                    predicateList.add(cb.like(root.get("userName"), likeUserName));
                }
                if (!StringUtils.isEmpty(tel)) {     //电话
                    String likeTel = "%" + tel + "%";
                    predicateList.add(cb.like(root.get("tel"), likeTel));
                }
                if (!StringUtils.isEmpty(password)) {     //密码
                    String likePassword = "%" + password + "%";
                    predicateList.add(cb.like(root.get("password"), likePassword));
                }
                if (userType != null && userType != All) {
                    predicateList.add(cb.equal(root.get("userType"), userType));
                }
                if (gender != null && gender != All) {
                    predicateList.add(cb.equal(root.get("gender"), gender));
                }
            }
            //不查管理员账号
            predicateList.add(cb.notEqual(root.get("userType"), ADMIN));
            Predicate[] pre = new Predicate[predicateList.size()];
            return query.where(predicateList.toArray(pre)).getRestriction();
        };
    }
}
