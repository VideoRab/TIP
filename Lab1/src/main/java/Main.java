import Interfaces.IHost;

public class Main {
    public static void main(String[] args) {
        IHost pieHost = new Host(args, new GenericController(new PieRepository()));
        IHost cocktailHost = new Host(args, new GenericController(new CocktailRepository()));
        pieHost.execute();
        cocktailHost.execute();
    }
}
