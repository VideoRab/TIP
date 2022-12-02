package com.example.demo.services;

import com.example.demo.models.Passenger;

import java.util.List;

public interface IPassengerService {
    List<Passenger> getAll();

    Passenger getById(Long id);

    void create(Passenger model, Long id);

    void update(Passenger model);

    void deleteById(Long id);
}
