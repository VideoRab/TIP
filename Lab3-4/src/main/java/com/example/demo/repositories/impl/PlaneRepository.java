package com.example.demo.repositories.impl;

import com.example.demo.models.Plane;
import com.example.demo.repositories.IGenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaneRepository implements IGenericRepository<Plane> {
    private final EntityManager planeManager;

    @Override
    public List getAll() {
        List<Plane> result = planeManager.createQuery("select p from Plane p", Plane.class).getResultList();
        return result;
    }

    @Override
    public Plane getById(Long id) {
        Plane result = planeManager.createQuery("from Plane p where p.id = :id", Plane.class)
                .setParameter("id", id)
                .getSingleResult();
        return result;
    }

    @Override
    public void create(Plane plane) {
        planeManager.persist(plane);
    }

    @Override
    public void update(Plane plane) {
        planeManager.merge(plane);
    }

    @Override
    public void delete(Plane plane) {
        planeManager.remove(plane);
    }
}
