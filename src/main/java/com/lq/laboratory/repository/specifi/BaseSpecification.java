package com.lq.laboratory.repository.specifi;

import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.lq.laboratory.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.github.wenhao.jpa.Specifications.and;

public class BaseSpecification<T> {

    // 查询条件全是 and 如 where userName = xxx and tel=xxx and userType=x
    public static <T> Specification findByAnd(Map<String, String> map) {

        PredicateBuilder<T> and = Specifications.<T>and();

        map.entrySet().stream().forEach(entry -> {
            and.eq(!StringUtils.isEmpty(entry.getValue()), entry.getKey(), entry.getValue());
        });
        return and.build();
    }

    public static <T> Specification findByAndInt(Map<String, Integer> map) {

        PredicateBuilder<T> and = Specifications.<T>and();

        map.entrySet().stream().forEach(entry -> {
            and.eq(!StringUtils.isEmpty(entry.getValue()), entry.getKey(), entry.getValue());
        });
        return and.build();
    }

}
