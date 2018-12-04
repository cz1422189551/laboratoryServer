package com.lq.laboratory.services;

import com.lq.laboratory.entity.Seat;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.repository.SeatRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl extends BaseServiceImpl<Seat> {


    @Resource(name = "seatRepository")
    @Override
    public void setRepository(BaseRepository<Seat, Integer> repository) {
        super.setRepository(repository);
    }


    public void initSeat() {
        int row = 10;
        int col = 10;
        List<Seat> seatList = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                Seat seat1 = new Seat(i, j);
                seatList.add(seat1);
            }
        }
        repository.saveAll(seatList);
    }

    @Transactional
    @Override
    public int update(Seat seat) {
        return 0;
    }
}
