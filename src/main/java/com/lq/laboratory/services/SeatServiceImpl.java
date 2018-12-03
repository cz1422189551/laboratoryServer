package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import com.lq.laboratory.entity.Seat;
import com.lq.laboratory.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements IService<Seat> {
    @Autowired
    SeatRepository repository;

    @Override
    public Seat getOne(String id) {
        return null;
    }

    @Override
    public Result<Seat> getList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<Seat> getAll() {
        return null;
    }

    @Override
    public Seat insert(Seat seat) {
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
        return null;
    }

    @Override
    public List<Seat> getAll(Specification<Seat> specification) {
        return repository.findAll(specification);
    }

    @Override
    public int update(Seat seat) {
        return 0;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }
}
