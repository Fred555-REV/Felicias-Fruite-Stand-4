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
            switch (product.getClass().getSimpleName().toLowerCase(Locale.ROOT)) {
                case "fruit":
                    fruits.remove(product);
                    break;
                case "meat":
                    meats.remove(product);
                    break;
            }
        } else {
            System.out.println("Not enough cash");
        }
    }

    private void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
