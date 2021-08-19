package fruit.stand.company;

import fruit.stand.Transaction;
import fruit.stand.Validation;
import fruit.stand.people.Cashier;
import fruit.stand.products.Product;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Console {
    private final Farm farm;
    private final Store store;
    private Cashier cashier;
    private final Scanner scan = new Scanner(System.in);

    public Console(Store store, Cashier cashier, Farm farm) {
        this.store = store;
        this.cashier = cashier;
        store.hire(cashier);
        this.farm = farm;
    }

    public void menu() {
        System.out.println("Welcome " + cashier.getName() + " The store has $" + store.getBalance());
        System.out.println("(1) Buy product for the store");
        System.out.println("(2) Check and throw away expired products");
        System.out.println("(3) Check pending transactions");
        System.out.println("(4) Take order from Customer");
    }

    public void takeAction() {
        int choice = Validation.inputInt("What will you do?");
        switch (choice) {
            case 1:
                buyProduct();
                break;
            case 2:
                tossExpiredProducts();
                break;
            case 3:
                System.out.println("handling these transactions");
                System.out.println(store.pendingTransactions);
                store.handlePendingtransactions();
                break;


        }
    }

    public void buyProduct() {
        System.out.println("Which product would you like to buy? (F)ruit/(M)eat");
        String input = scan.next();
        Product product;
        int choice;
        switch (input.toUpperCase(Locale.ROOT)) {
            case "F":
                System.out.println(farm.getFruits());
                choice = Validation.inputInt("Choose 1-" + farm.getFruits().size(), 1, farm.getFruits().size());
                product = farm.getFruit(choice-1);
                break;
            case "M":
                System.out.println(farm.getMeats());
                choice = Validation.inputInt("Choose 1-" + farm.getMeats().size(), 1, farm.getMeats().size());
                product = farm.getMeat(choice-1);
                break;
            default:
                product = null;
                buyProduct();
                break;
        }
        if (product != null) {
            store.addTransaction(new Transaction(product.getCost(), cashier, farm.getFarmer(), product));
        }
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
