package com.lq.laboratory.repository.specifi;

import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.lq.laboratory.entity.User;
import com.lq.laboratory.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import static com.github.wenhao.jpa.Specifications.and;
import static com.lq.laboratory.util.Const.All;

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

    protected static List<Date> mapObjectToRangeDateTime(Map<String, Object> map, String key) {
        if (map.get(key) != null) {
            List<String> rangeDateTime = (List<String>) map.get(key);
            if (rangeDateTime.size() < 2) return null;

            String startDateStr = rangeDateTime.get(0);
            String endDateStr = rangeDateTime.get(1);

            Date startDate = dateStrToAddDate(startDateStr);
            Date endDate = dateStrToAddDate(endDateStr);
            return Arrays.asList(startDate, endDate);
        } else {
            return null;
        }
    }


    protected static Integer mapObjectToInteger(Map<String, Object> map, String key) {
        if (map.get(key) != null) {
            Object o = map.get(key);
            Integer i = All;
            if (o instanceof String) {
            } else {
                i = (Integer) map.get(key);
            }
            return i;
        } else {
            return null;
        }
    }

    protected static Date mapObjectToDate(Map<String, Object> map, String key) {
        if (map.get(key) != null) {
            String dateStr = map.get(key) + "";
            return dateStrToAddDate(dateStr);
        }
        return null;
    }

    private static Date dateStrToAddDate(String dateStr) {
        Date date = null;
        try {
            date = DateUtil.stringToDate(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate localDate = DateUtil.dateToLocalDate(date);
        return DateUtil.localDateToDate(localDate.plusDays(1));
    }

}
