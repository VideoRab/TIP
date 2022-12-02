package com.example.demo.services.impl;

import com.example.demo.models.Plane;
import com.example.demo.repositories.IGenericRepository;
import com.example.demo.services.IGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService implements IGenericService<Plane> {
    private final IGenericRepository<Plane> planeRepository;

    @Override
    @Transactional
    public List<Plane> getAll() {
        List<Plane> result = planeRepository.getAll();
        return result;
    }

    @Override
    @Transactional
    public Plane getById(Long id) {
        Plane result = planeRepository.getById(id);
        return result;
    }

    @Override
    @Transactional
    public void create(Plane plane) {
        planeRepository.create(plane);
    }

    @Override
    @Transactional
    public void update(Plane plane) {
        planeRepository.update(plane);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Plane target = planeRepository.getById(id);
        planeRepository.delete(target);
    }
}
