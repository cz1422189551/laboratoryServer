//package com.lq.laboratory.services;
//
//import com.lq.laboratory.entity.LaboratorySeat;
//import com.lq.laboratory.entity.Result;
//import com.lq.laboratory.repository.BaseRepository;
//import com.lq.laboratory.repository.LaboratorySeatRepository;
//import com.lq.laboratory.services.base.BaseServiceImpl;
//import com.lq.laboratory.services.base.IService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class LaboratorySeatServiceImpl extends BaseServiceImpl<LaboratorySeat> {
//
//    @Resource(name = "laboratorySeatRepository")
//    @Override
//    public void setRepository(BaseRepository<LaboratorySeat, Integer> repository) {
//        super.setRepository(repository);
//    }
//
//
////    @Transactional
////    @Override
////    public int update(LaboratorySeat laboratorySeat) {
////        return 0;
////    }
//}
