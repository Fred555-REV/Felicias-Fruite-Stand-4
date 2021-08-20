package fruit.stand;

import fruit.stand.company.Console;
import fruit.stand.products.Farm;
import fruit.stand.company.Store;
import fruit.stand.people.Cashier;
import fruit.stand.people.Customer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Farm stateFarm = new Farm();
        Store fruiteStand = new Store(500);
        Cashier cashier = new Cashier("Felicia", 500);
        Customer customer1 = new Customer("Freddy", 50);
        Customer customer2 = new Customer("Bob", 50);
        Customer customer3 = new Customer("Karl", 50);
        List<Customer> customers = List.of(customer1, customer2, customer3);
        Console console = new Console(fruiteStand, cashier, stateFarm, customers);
        while (true) {
            console.menu();
            console.takeAction();
        }

//        stateFarm;
//        fruiteStand;
//        cashier;
//        customer1;
//        customer2;
//        customer3;
//        console;

    }
}
