package Controllers;

import Interfaces.IGenericRepository;

import java.util.ArrayList;

public class GenericController<TViewModel> {
    private final IGenericRepository<TViewModel> repository;

    public GenericController(IGenericRepository<TViewModel> repository) {
        this.repository = repository;
    }

    public ArrayList<TViewModel> getAll() {
        return repository.getAll();
    }

    public int getSumOfCalories() {
        return repository.getSumOfCalories();
    }

    public ArrayList<TViewModel> getAllSortedByCalories() {
        return repository.getAllSortedByCalories();
    }
}
