import Interfaces.Nutritious;

import java.util.Random;

public abstract class Food implements Nutritious {
    protected String name;
    protected int calories;

    public Food(String name) {
        this.name = name;
        calculateCalories();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void calculateCalories() {
        calories = (new Random()).nextInt(100) % name.length() + 1;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return name.equals(food.name);
    }
}
