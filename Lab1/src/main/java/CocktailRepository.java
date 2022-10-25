import Interfaces.IGenericRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CocktailRepository implements IGenericRepository<Cocktail> {
    private final ArrayList<Cocktail> dbSet = new ArrayList<Cocktail>();

    public CocktailRepository() {
        dbSet.add(new Cocktail("Cocktail1", "кислый", "яблоко"));
        dbSet.add(new Cocktail("Cocktail2", "сладкий", "вишня"));
        dbSet.add(new Cocktail("Cocktail3", "сухой", "виноград"));
    }

    @Override
    public ArrayList<Cocktail> getAll() {
        return dbSet;
    }

    @Override
    public int getSumOfCalories() {
        int result = dbSet.stream().mapToInt(tEntity -> tEntity.calories).sum();
        return result;
    }

    @Override
    public ArrayList<Cocktail> getAllSortedByCalories() {
        ArrayList<Cocktail> result = dbSet.stream().sorted(new FoodComparatorByCalories().reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}
