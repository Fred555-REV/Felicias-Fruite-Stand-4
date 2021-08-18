package fruit.stand.company;

import fruit.stand.Validation;
import fruit.stand.company.Farm;
import fruit.stand.company.Store;
import fruit.stand.people.Cashier;
import fruit.stand.products.Fruit;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Console {
    private Farm farm;
    private Store store;
    private Cashier cashier;
    private static Scanner scan;

    public Console(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
        store.hire(cashier);
    }

    public void menu() {
        System.out.println("Welcome " + cashier.getName());
        System.out.println("(1) Buy product for the store");
        System.out.println("(2) Check and throw away expired products");
        System.out.println("(3) Check pending transactions");
        System.out.println("(4) Sell product to customer");
    }

    public void takeAction() {
        int choice = Validation.inputInt("What will you do?");
        switch (choice) {
            case 1:
                buyProduct();
                break;
            case 2:
                tossExpiredProducts();


        }
    }

    public void buyProduct() {
        System.out.println("Which product would you like to buy?");

    }

    public void tossExpiredProducts() {
        store.displayProducts();
        store.getFruits().removeIf(fruit -> fruit.getExpDate().before(Date.from(Instant.now())));
        store.displayProducts();
    }

    private Cashier getCashier() {
        return cashier;
    }
}
