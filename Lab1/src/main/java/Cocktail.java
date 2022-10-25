public class Cocktail extends Food {
    private String drink;
    private String fruit;

    public Cocktail(String name, String drink, String fruit) {
        super(name);
        this.drink = drink;
        this.fruit = fruit;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "drink='" + drink + '\'' +
                ", fruit='" + fruit + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
