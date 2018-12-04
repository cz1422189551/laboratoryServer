package com.lq.laboratory.repository.specifi;

import com.lq.laboratory.entity.Seat;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.*;

public class SeatSpecification {

    /**
     *  查询 小于 第x排y列的座位
     * @param row
     * @param col
     * @return
     */
    public static Specification<Seat> getSeatList(int row, int col) {
        return (root, query, cb) -> {
            return cb.and(
                    cb.lessThanOrEqualTo(root.get("rowIndex"), row)
                    , cb.lessThanOrEqualTo(root.get("colIndex"), col)
            );
        };
    }
}
