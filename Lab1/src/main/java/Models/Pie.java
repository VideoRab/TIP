package Models;

public class Pie extends Food {
    private String filling;

    public Pie(String name, String filling) {
        super(name);
        this.filling = filling;
    }

    public String getSyrup() {
        return filling;
    }

    public void setSyrup(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "syrup='" + filling + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
