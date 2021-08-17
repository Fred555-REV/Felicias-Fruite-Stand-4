package fruit.stand;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Store {
    private double balance;
    private List<Fruit> fruits;
    private List<Meat> meats;

    public Store(double balance) {
        this.balance = balance;
        this.fruits = new ArrayList<>();
        this.meats = new ArrayList<>();
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void sell(Product product, Person person) {
        if (person.pay(product.getCost())) {
            setBalance(balance + product.getCost());
            remove(product);
        } else {
            System.out.println("Not enough cash");
        }
    }

    public void buy(Product product) {
        if (product.getCost() > balance) {
            System.out.println("Not enough money to buy \ntype:" + product.getType() + "\nsubtype:" + product.getType());
        } else {
            setBalance(balance - product.getCost());
            add(product);
        }
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

    public List<Fruit> getFruits() {
        return fruits;
    }
}
