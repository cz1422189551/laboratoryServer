package com.lq.laboratory.services.base;

import com.lq.laboratory.entity.BaseEntity;
import com.lq.laboratory.entity.Result;
import com.lq.laboratory.repository.BaseRepository;
import com.lq.laboratory.util.EntityFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseServiceImpl<T> implements IService<T> {

    @Autowired
    EntityManager entityManager;


    @Override

    public T updateEntity(T t) {
        BaseEntity entity = (BaseEntity) t;
        T one = getOne(String.valueOf(entity.getId()));
        if (one == null) return null;
        return repository.saveAndFlush(t);
    }

    protected BaseRepository<T, Integer> repository;

    @Override
    public T getOne(String id) {
        T t = repository.findById(Integer.valueOf(id)).orElse(null);
        if (t == null) throw new RuntimeException("没有找到" + id + "记录");
        return t;
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
        return repository.saveAndFlush(t);
    }

    @Transactional
    @Override
    public int update(T t) {
        return updateEntity(t) == null ? 0 : 1;
    }

    @Transactional
    @Override
    public boolean delete(String id) {
        repository.deleteById(Integer.valueOf(id));
        return true;
    }


    @Transactional
    @Override
    public void delete(T t) {
        repository.delete(t);
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
