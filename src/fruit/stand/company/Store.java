package fruit.stand.company;

import fruit.stand.Transaction;
import fruit.stand.people.Cashier;
import fruit.stand.people.Person;
import fruit.stand.products.Fruit;
import fruit.stand.products.Meat;
import fruit.stand.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Store {
    private Cashier cashier;
    private double balance;
    private List<Fruit> fruits;
    private List<Meat> meats;
    protected List<Transaction> pendingTransactions;
    private List<Transaction> transactionHistory;

    public Store(double balance) {
        this.balance = balance;
        this.fruits = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.pendingTransactions = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }


    protected void hire(Cashier cashier) {
        if (this.cashier == null) {
            setCashier(cashier);
        }
    }

    protected void handlePendingtransactions() {
        for (Transaction transaction : pendingTransactions) {
            if (transaction.getTo().getName().equals(cashier.getName())) {
                if (sell(transaction.getProduct(), transaction.getFrom())) {
                    transactionHistory.add(transaction);
                    pendingTransactions.remove(transaction);
                }
            } else if (transaction.getFrom().getName().equals(cashier.getName())) {
                for (int i = 0; i < transaction.getAmount(); i++) {
                    buy(transaction.getProduct());
                }
            }
        }
    }

    protected void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    private Boolean sell(Product product, Person person) {
        if (person.pay(product.getCost())) {
            setBalance(balance + product.getCost());
            remove(product);
            return true;
        } else {
            System.out.println(person.getName() + " does not have enough cash try again later.");
            return false;
        }
    }

    private boolean buy(Product product) {
        if (product.getCost() > balance) {
            System.out.println("Not enough money to buy \nname:" + product.getName() + "\ntype:" + product.getType());
            return false;
        } else {
            setBalance(balance - product.getCost());
            add(product);
            return true;
        }
    }

    private void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }


    private void remove(Product product) {
        switch (product.getClass().getSimpleName().toLowerCase(Locale.ROOT)) {
            case "fruit":
                fruits.remove((Fruit) product);
                break;
            case "meat":
                meats.remove((Meat) product);
                break;
        }
    }

    private void add(Product product) {
        switch (product.getClass().getSimpleName().toLowerCase(Locale.ROOT)) {
            case "fruit":
                fruits.add((Fruit) product);
                break;
            case "meat":
                meats.add((Meat) product);
                break;
        }
    }

    protected void displayProducts() {
        System.out.println(getFruits());
        System.out.println(getMeats());
    }

    protected List<Meat> getMeats() {
        return meats;
    }

    protected List<Fruit> getFruits() {
        return fruits;
    }

    protected double getBalance() {
        return balance;
    }
}
