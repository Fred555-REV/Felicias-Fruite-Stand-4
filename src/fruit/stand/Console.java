package fruit.stand;

import fruit.stand.company.Store;
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
        System.out.println("(1) Buy products for the store");
        System.out.println("(2) Check and throw away expired products");
        System.out.println("(3) deal with pending transactions");
        System.out.println("");
    }

    public void takeAction() {
        int choice = Validation.inputInt("What will you do?");
        switch (choice) {
            case 1:


        }
    }

    public void chooseProduct() {

    }

    public Cashier getCashier() {
        return cashier;
    }
}
