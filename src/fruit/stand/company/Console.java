package fruit.stand.company;

import fruit.stand.Transaction;
import fruit.stand.Validation;
import fruit.stand.people.Cashier;
import fruit.stand.people.Customer;
import fruit.stand.products.Fruit;
import fruit.stand.products.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Console {
    private final Farm farm;
    private final Store store;
    private Cashier cashier;
    private List<Customer> customers;
    private final Scanner scan = new Scanner(System.in);
    private int hour;
    private String minutes;

    public Console(Store store, Cashier cashier, Farm farm, List<Customer> customers) {
        this.store = store;
        this.cashier = cashier;
        store.hire(cashier);
        this.farm = farm;
        this.customers = customers;
        hour = 8;
        minutes = ":30";
    }

    public void menu() {
        if (minutes.equalsIgnoreCase(":30")) {
            if (hour == 12) {
                hour = 0;
            }
            hour++;
            minutes = ":00";
        } else if (minutes.equalsIgnoreCase(":00")) {
            minutes = ":30";
        }
        System.out.println("Welcome " + cashier.getName() + " The store has $" + store.getBalance());
        System.out.println("It is " + hour + minutes);
        System.out.println("There are " + store.pendingTransactions.size() + " transactions pending.");
        if (hour == 5) {
            System.out.println("(0) You can end your shift now.");
        }
        System.out.println("(1) Order a product for the store.");
        System.out.println("(2) Take order from Customer");
        System.out.println("(3) Check for expired items.");
        System.out.println("(4) Handle pending transactions");
        System.out.println("(5) Take inventory of products");
    }

    public void takeAction() {
        int choice = Validation.inputInt("What will you do?");
        switch (choice) {
            case 0:
                if (hour == 5) {
                    System.out.println("Good bye");
                    System.exit(200);
                } else {
                    System.out.println("It is not your time...");
                    takeAction();
                }
                break;
            case 1:
                buyProduct();
                break;
            case 2:
                takeOrder();
                break;
            case 3:
                tossExpiredProducts();
                break;
            case 4:
                System.out.println("handling these transactions");
                System.out.println(store.pendingTransactions);
                store.handlePendingtransactions();
                break;
            case 5:
                store.displayProducts();
                break;
            default:
                takeAction();
                break;
        }
    }

    private void takeOrder() {
        int customerIndex = (int) Math.floor(Math.random() * 3) + 1;
        Customer current = customers.get(customerIndex);
        int productType = (int) Math.floor(Math.random() * 2) + 1;
        int randomIndex;
        int amount;
        Product product;
        switch (productType) {
            case 1:
                randomIndex = (int) Math.floor(Math.random() * store.getFruits().size()) + 1;
                product = store.getFruits().get(randomIndex);
                amount = (int) Math.floor(Math.random() * product.getAmount()) + 1;
                System.out.println(current.getName() + " orders " + amount);
                break;
            case 2:
                randomIndex = (int) Math.floor(Math.random() * store.getMeats().size()) + 1;
                System.out.println(current.getName() + " orders ");
        }
    }

    private void buyProduct() {
        System.out.println("Which product would you like to order? (F)ruit/(M)eat");
        System.out.println("Store has $" + store.getBalance());
        String input = scan.next();
        Product product;
        int choice;
        switch (input.toUpperCase(Locale.ROOT)) {
            case "F":
                farm.displayFruits();
                choice = Validation.inputInt("Choose 1-" + farm.getFruits().size(), 1, farm.getFruits().size());
                product = farm.getFruit(choice - 1);
                break;
            case "M":
                farm.displayMeats();
                choice = Validation.inputInt("Choose 1-" + farm.getMeats().size(), 1, farm.getMeats().size());
                product = farm.getMeat(choice - 1);
                break;
            default:
                product = null;
                buyProduct();
                break;
        }
        if (product != null) {
            System.out.println("Store has $" + store.getBalance());
            int amount = Validation.inputInt("How many 1-5?", 1, 5);
            product.setAmount(amount);
            store.addTransaction(new Transaction(product.getCost() * amount, cashier, farm.getFarmer(), product));
        }
    }

    private void tossExpiredProducts() {
        store.displayProducts();
        store.getFruits().removeIf(fruit -> fruit.getExpDate().isAfter(LocalDate.now()));
    }

    private Cashier getCashier() {
        return cashier;
    }
}
