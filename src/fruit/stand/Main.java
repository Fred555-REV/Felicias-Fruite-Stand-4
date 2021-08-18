package fruit.stand;

import fruit.stand.company.Console;
import fruit.stand.company.Store;
import fruit.stand.people.Cashier;
import fruit.stand.people.Customer;

public class Main {

    public static void main(String[] args) {
        Store wallMart = new Store(500);
        Cashier cashier = new Cashier("Karl", 500);
        Customer customer = new Customer("Freddy", 50);
        Console console = new Console(wallMart, cashier);
        while (true) {
            console.menu();
            console.takeAction();

        }


    }
}
