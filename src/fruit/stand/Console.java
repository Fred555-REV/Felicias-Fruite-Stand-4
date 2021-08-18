package fruit.stand;

import fruit.stand.people.Cashier;

import java.util.Scanner;

public class Console {
    private Store store;
    private Cashier cashier;
    private static Scanner scan;

    public Console(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    public void menu() {
        System.out.println("Welcome " + cashier.getName());
        System.out.println("(1) Stock the store");
        System.out.println("(2) check and throw away expired products");
        System.out.println("(3) Check for orders");
        System.out.println("");
    }

    public Cashier getCashier() {
        return cashier;
    }
}
