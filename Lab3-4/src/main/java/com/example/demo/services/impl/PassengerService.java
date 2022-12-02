package com.example.demo.services.impl;

import com.example.demo.models.Passenger;
import com.example.demo.models.Plane;
import com.example.demo.repositories.IGenericRepository;
import com.example.demo.services.IGenericService;
import com.example.demo.services.IPassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService implements IPassengerService {
    private final IGenericRepository<Passenger> passengerRepository;
    private final IGenericRepository<Plane> planeRepository;

    @Override
    @Transactional
    public List<Passenger> getAll() {
        List<Passenger> result = passengerRepository.getAll();
        return result;
    }

    @Override
    @Transactional
    public Passenger getById(Long id) {
        Passenger result = passengerRepository.getById(id);
        return result;
    }

    @Transactional
    public void create(Passenger passenger, Long id) {
        Plane plane = planeRepository.getById(id);
        passenger.setPlane(plane);
        passengerRepository.create(passenger);
    }

    @Override
    @Transactional
    public void update(Passenger passenger) {
        passengerRepository.update(passenger);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Passenger target = passengerRepository.getById(id);
        passengerRepository.delete(target);
    }
}
