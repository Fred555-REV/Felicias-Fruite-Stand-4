package fruit.stand;

import fruit.stand.company.Console;
import fruit.stand.company.Farm;
import fruit.stand.company.Store;
import fruit.stand.people.Cashier;
import fruit.stand.people.Customer;
import fruit.stand.products.Fruit;

import java.time.Instant;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Farm stateFarm = new Farm();
        Store wallMart = new Store(500);
        Cashier cashier = new Cashier("Karl", 500);
        Customer customer = new Customer("Freddy", 50);
        Console console = new Console(wallMart, cashier, stateFarm);
        while (true) {
            console.menu();
            console.takeAction();

        }


    }
}
