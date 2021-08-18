package fruit.stand.company;

import fruit.stand.products.Fruit;
import fruit.stand.products.Meat;
import fruit.stand.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private List<Fruit> fruits;
    private List<Meat> meats;

    public Farm() {
        this.fruits = new ArrayList<>();
        this.meats = new ArrayList<>();
        addFruit("Apple", "Gala", 1.5, 20);
        addFruit("Apple", "Fuji", 2.5, 15);
        addFruit("Orange", "Blood", 1.75, 25);
        addFruit("Orange", "Cara Cara", 2, 23);
        addMeat("Chicken");
    }

    private void addFruit(String name, String subType, double cost, int amount) {
        //fruit , name, subtype, expDate, cost, amount
    }

    private void addMeat(String name) {
//        meats.add( name);
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public List<Meat> getMeats() {
        return meats;
    }
}
