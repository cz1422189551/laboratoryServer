//package com.lq.laboratory.repository.specifi;
//
//import com.lq.laboratory.entity.LaboratorySeat;
//import com.lq.laboratory.entity.Seat;
//import org.springframework.data.jpa.domain.Specification;
//
//public class LaboratorySeatSpecification {
//
//    /**
//     *
//     *
//     * @return
//     */
//    public static Specification<LaboratorySeat> findBySeatIdAndLaboratoryId(int laboratoryId) {
//        return (root, query, cb) -> {
//            return cb.equal(root.get("laboratory").get("id"), laboratoryId);
//        };
//    }
//
//
//
//}
