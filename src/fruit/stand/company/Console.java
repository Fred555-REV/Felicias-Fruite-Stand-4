package fruit.stand.company;

import fruit.stand.Validation;
import fruit.stand.people.Cashier;
import fruit.stand.people.Customer;
import fruit.stand.products.Farm;
import fruit.stand.products.Product;

import java.time.LocalDate;
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
    private boolean isShiftOver;
    private boolean isAutomatic;

    public Console(Store store, Cashier cashier, Farm farm, List<Customer> customers) {
        this.store = store;
        this.cashier = cashier;
        store.hire(cashier);
        this.farm = farm;
        this.customers = customers;
        hour = 8;
        minutes = ":30";
        isShiftOver = false;
        isAutomatic = false;
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
        System.out.println("Welcome " + cashier.getName());
        System.out.println("It is " + hour + minutes);
        if (isAutomatic) {
            System.out.println("Automatically handling transactions.");
            store.handlePendingtransactions();
        } else {
            System.out.println("There are " + store.pendingTransactions.size() + " transactions pending.");
        }
        System.out.println("The Fruite Stand has $" + store.getBalance());
        if (hour == 5 || isShiftOver) {
            isShiftOver = true;
            System.out.println("(0) You can end your shift now.");
        }
        System.out.println("(1) Order a product for the store.");
        System.out.println("(2) Take order from Customer");
        System.out.println("(3) Check for expired items.");
        System.out.println("(4) Handle pending transactions");
        System.out.println("(5) Take inventory of products");
        System.out.print("(6) Handle transactions automatically (toggle is ");
        if (isAutomatic) {
            System.out.print("on)\n");
        } else {
            System.out.print("off)\n");
        }
        System.out.println("(7) Show transaction history");
    }

    public void takeAction() {
        int choice = Validation.inputInt("What will you do?");
        switch (choice) {
            case 0:
                if (isShiftOver) {
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
            case 6:
                isAutomatic = true;
                break;
            case 7:
                System.out.println(store.getTransactionHistory());
                break;
            default:
                takeAction();
                break;
        }
    }

    private void takeOrder() {
        int customerIndex = (int) Math.floor(Math.random() * customers.size());
        Customer current = customers.get(customerIndex);
        System.out.println(current);
        int productType = (int) Math.floor(Math.random() * 2) + 1;
        int randomIndex;
        int amount = 0;
        Product product = null;
        switch (productType) {
            case 1:
                if (store.getFruits().size() > 0) {
                    randomIndex = (int) Math.floor(Math.random() * store.getFruits().size());
                    product = store.getFruits().get(randomIndex);
//                    product = new Fruit(product.getName(), product.getType(), product.getExpDate(), product.getCost(), product.getAmount(), store.getFruits().get(randomIndex).getColor());
                    amount = (int) Math.floor(Math.random() * product.getAmount()) + 1;
                    System.out.println(current.getName() + " orders " + amount + " " + product.getName() + " for $" + (product.getCost() * store.getPricePercent()));
                } else {
                    System.out.println("Customer left because there were no fruits.");
                }
                break;
            case 2:
                if (store.getMeats().size() > 0) {
                    randomIndex = (int) Math.floor(Math.random() * store.getMeats().size());
                    product = store.getMeats().get(randomIndex);
//                    product = new Meat(product.getName(), product.getType(), product.getExpDate(), product.getCost(), product.getAmount(), store.getMeats().get(randomIndex).getCookLevel());
                    amount = (int) Math.floor(Math.random() * product.getAmount()) + 1;
                    System.out.println(current.getName() + " orders " + amount + " " + product.getName() + " for $" + (product.getCost() * store.getPricePercent()));
                } else {
                    System.out.println("Customer left because there were no meats.");
                }
                break;
            default:
                takeOrder();
                break;
        }
        if (product != null) {
            store.addTransaction(new Transaction(amount, current, cashier, product));
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
            int amount = Validation.inputInt("How many 1-10?", 1, 10);
            product.setAmount(amount);
            store.addTransaction(new Transaction(amount, cashier, farm.getFarmer(), product));
        }
    }

    private void tossExpiredProducts() {
        store.displayProducts();
        store.getFruits().removeIf(fruit -> fruit.getExpDate().isBefore(LocalDate.from(LocalDate.now())));
        store.getMeats().removeIf(meat -> meat.getExpDate().isBefore(LocalDate.from(LocalDate.now())));
    }

    private Cashier getCashier() {
        return cashier;
    }
}
