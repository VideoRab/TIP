import Interfaces.IGenericRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PieRepository implements IGenericRepository<Pie> {
    private final ArrayList<Pie> dbSet = new ArrayList<Pie>();

    public PieRepository() {
        dbSet.add(new Pie("Pie1", "вишнёвая"));
        dbSet.add(new Pie("Pie2", "клубничная"));
        dbSet.add(new Pie("Pie3", "яблочная"));
    }

    @Override
    public ArrayList<Pie> getAll() {
        return dbSet;
    }

    @Override
    public int getSumOfCalories() {
        int result = dbSet.stream().mapToInt(tEntity -> tEntity.calories).sum();
        return result;
    }

    @Override
    public ArrayList<Pie> getAllSortedByCalories() {
        ArrayList<Pie> result = dbSet.stream().sorted(new FoodComparatorByCalories())
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}
