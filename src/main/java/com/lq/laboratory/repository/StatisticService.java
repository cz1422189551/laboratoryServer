package com.lq.laboratory.repository;

import com.lq.laboratory.entity.Appointment;
import com.lq.laboratory.util.FormatUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.lq.laboratory.util.Const.APPOINTING;
import static com.lq.laboratory.util.Const.STUDENT;

@Service
public class StatisticService {

    @PersistenceContext
    EntityManager entityManager;


    public List findEveryMonthCountByYear(Map<String, String> dateMap) {

        StringBuilder datePredicate = appendWhereYearOrMonthOrDayPredicate(dateMap);

        String sql = "select year(ap.appointment_date) as 'year',MONTH(ap.appointment_date) as 'month',count(id) as 'count'\n" +
                "from appointment ap where 1=1  " + datePredicate.toString() + " \n" +
                " group by year(ap.appointment_date),MONTH(ap.appointment_date)\n";
        return executeNativeSql(sql);
    }

    /**
     * 通过时间查询，每个时间点的( 可用实验室）使用情况
     *
     * @param dateMap       2018 , 12 ,25
     * @param availableType STUDENT ,TEACHER
     * @return
     */
    public List findDatePointUsingByDate(Map<String, String> dateMap, int availableType) {

        StringBuilder queryPredicate = appendWhereYearOrMonthOrDayPredicate(dateMap);

        String sql = "select (appointment_date) as 'startDatePoint',avg(`minute`)as 'avgMinute',sum(`minute`) as'sumMinute'\n" +
                ",sum(seat_count) as 'sumSeatCount',count(1)state\n" +
                "from appointment_info_view\n" +
                "where 1=1 and available_type=" + availableType + " " + queryPredicate.toString() +
                "GROUP BY appointment_date,seat_count\n" +
                "having state>=" + APPOINTING;


        return executeNativeSql(sql);

    }

    /**
     * 添加查询 年月日 的条件 可选
     *
     * @param map map key [year,month,day]
     * @return and year(date)=year and month(month)=month and day(day)=day
     */
    private StringBuilder appendWhereYearOrMonthOrDayPredicate(Map<String, String> map) {
        String year = map.get("year");
        String month = map.get("month");
        String day = map.get("day");
        StringBuilder sb = new StringBuilder();
        //添加年
        if (!FormatUtil.isEmpty(year)) {
            sb.append("and year(date)=" + year + " ");
        }
        //添加月
        if (!FormatUtil.isEmpty(month)) {
            sb.append("and " + "month(date)=" + month + " ");
        }
        //添加日
        if (!FormatUtil.isEmpty(day)) {
            sb.append("and " + "day(date)=" + day + " ");
        }
        return sb;
    }

    /**
     * 执行原生的SQL
     *
     * @param sql 原生sql
     * @return List<Map   <   String   ,   Object>
     */
    private List executeNativeSql(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }
}
