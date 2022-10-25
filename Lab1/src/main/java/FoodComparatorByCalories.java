import java.util.Comparator;

public class FoodComparatorByCalories implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        if (o1 == null)
            return 1;
        if (o2 == null)
            return -1;

        int o1NameLength = o1.getCalories();
        int o2NameLength = o2.getCalories();
        if (o1NameLength < o2NameLength)
            return -1;
        else if (o1NameLength > o2NameLength)
            return 1;

        return 0;
    }
}
