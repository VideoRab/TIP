package com.example.demo.services;

import java.util.List;

public interface IGenericService<TModel> {
    List<TModel> getAll();

    TModel getById(Long id);

    void create(TModel model);

    void update(TModel model);

    void deleteById(Long id);
}
