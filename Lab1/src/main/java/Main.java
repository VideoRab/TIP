import Controllers.GenericController;
import Handlers.Host;
import Interfaces.IHost;
import Repositories.CocktailRepository;
import Repositories.PieRepository;

public class Main {
    public static void main(String[] args) {
        IHost pieHost = new Host(args, new GenericController(new PieRepository()));
        IHost cocktailHost = new Host(args, new GenericController(new CocktailRepository()));
        pieHost.execute();
        cocktailHost.execute();
    }
}
