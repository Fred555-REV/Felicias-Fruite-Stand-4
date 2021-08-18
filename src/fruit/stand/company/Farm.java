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
        addFruit("Apple");
        addFruit("Banana");
        addFruit("Orange");
        addMeat("Chicken");
    }

    private void addFruit(String name) {
//        fruits.add(new Fruit(name, 12);
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
