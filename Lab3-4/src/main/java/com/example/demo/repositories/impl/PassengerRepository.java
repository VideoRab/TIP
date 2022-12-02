package com.example.demo.repositories.impl;

import com.example.demo.models.Passenger;
import com.example.demo.repositories.IGenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PassengerRepository implements IGenericRepository<Passenger> {
    private final EntityManager passengerManager;

    @Override
    public List<Passenger> getAll() {
        List<Passenger> result = passengerManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
        return result;
    }

    @Override
    public Passenger getById(Long id) {
        Passenger result = passengerManager.createQuery("from Passenger p where p.id = :id", Passenger.class)
                .setParameter("id", id)
                .getSingleResult();
        return result;
    }

    @Override
    public void create(Passenger passenger) {
        passengerManager.merge(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        passengerManager.merge(passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        passengerManager.remove(passenger);
    }
}
