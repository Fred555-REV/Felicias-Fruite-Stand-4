package fruit.stand;

public class Main {

    public static void main(String[] args) {
        Store wallMart = new Store(500);
        Cashier freddy = new Cashier("Freddy", 500);
        Console console = new Console(wallMart, freddy);
        while (true) {
            console.menu();

        }


    }
}
