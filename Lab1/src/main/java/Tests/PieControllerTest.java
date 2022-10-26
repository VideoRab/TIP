package Tests;

import Controllers.GenericController;
import Models.Pie;
import Repositories.PieRepository;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PieControllerTest {

    @Test
    public void getAllNotNull() {
        GenericController pieController = new GenericController(new PieRepository());

        ArrayList<Pie> actual = pieController.getAll();

        Assert.assertNotNull(actual);
    }

    @Test
    public void getAll() {
        GenericController pieController = new GenericController(new PieRepository());
        ArrayList<Pie> expected = List.of(
                new Pie("Pie1", "вишнёвая"),
                new Pie("Pie2", "клубничная"),
                new Pie("Pie3", "яблочная")
        ).stream().collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Pie> actual = pieController.getAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllSortedByCalories() {
        GenericController pieController = new GenericController(new PieRepository());
        ArrayList<Pie> expected = pieController.getAll();
        expected.sort(Comparator.comparing(Pie::getCalories));

        ArrayList<Pie> actual = pieController.getAllSortedByCalories();

        Assert.assertEquals(expected, actual);
    }
}