package Interfaces;

import java.util.ArrayList;

public interface IGenericRepository<TEntity> {
    ArrayList<TEntity> getAll();
    int getSumOfCalories();

    ArrayList<TEntity> getAllSortedByCalories();
}
