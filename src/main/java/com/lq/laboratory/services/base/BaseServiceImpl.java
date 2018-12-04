package com.lq.laboratory.services.base;

import com.lq.laboratory.entity.BaseEntity;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.util.EntityFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseServiceImpl<T> implements IService<T> {

    protected BaseRepository<T, Integer> repository;

    @Override
    public T getOne(String id) {
        return repository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public Result<T> getList(int pageNumber, int pageSize) {
        Page<T> page = repository.findAll(EntityFactory.createPageable(pageNumber, pageSize));

        return EntityFactory.createResult(page);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public T insert(T t) {
        return repository.save(t);
    }

    @Transactional
    @Override
    public int update(T t) {
        BaseEntity entity = (BaseEntity) t;
        T one = getOne(entity.getId() + "");
        if (one == null) return 0;
        return repository.saveAndFlush(t) == null ? 0 : 1;
    }

    @Transactional
    @Override
    public boolean delete(String id) {
        repository.deleteById(Integer.valueOf(id));
        return true;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public Page<T> getList(Specification<T> specification, int pageNumber, int pageSize) {
        return repository.findAll(specification, EntityFactory.createPageable(pageNumber, pageSize));
    }

    @Override
    public List<T> getAll(Specification<T> specification) {
        return repository.findAll(specification);
    }
}
