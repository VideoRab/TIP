package Tests;

import Controllers.GenericController;
import Handlers.Host;
import Interfaces.IHost;
import Models.Cocktail;
import Repositories.CocktailRepository;
import RuntimeExceptions.MyException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CocktailControllerTest {
    @Test
    public void getAllNotNull() {
        GenericController cocktailController = new GenericController(new CocktailRepository());

        ArrayList<Cocktail> actual = cocktailController.getAll();

        Assert.assertNotNull(actual);
    }

    @Test
    public void getAll() {
        GenericController cocktailController = new GenericController(new CocktailRepository());
        ArrayList<Cocktail> expected = List.of(
                new Cocktail("Cocktail1", "кислый", "яблоко"),
                new Cocktail("Cocktail2", "сладкий", "вишня"),
                new Cocktail("Cocktail3", "сухой", "виноград")
        ).stream().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Cocktail> actual = cocktailController.getAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllSortedByCalories() {
        GenericController cocktailController = new GenericController(new CocktailRepository());
        ArrayList<Cocktail> expected = cocktailController.getAll();
        expected.sort(Comparator.comparing(Cocktail::getCalories).reversed());

        ArrayList<Cocktail> actual = cocktailController.getAllSortedByCalories();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MyException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        IHost cocktailHost = new Host(new String[] { "-gg" }, new GenericController(new CocktailRepository()));
        cocktailHost.execute();
    }
}
