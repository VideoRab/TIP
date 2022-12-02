package com.example.demo.repositories;

import java.util.List;

public interface IGenericRepository<TEntity> {
    List<TEntity> getAll();

    TEntity getById(Long id);

    void create(TEntity entity);

    void update(TEntity entity);

    void delete(TEntity entity);
}
