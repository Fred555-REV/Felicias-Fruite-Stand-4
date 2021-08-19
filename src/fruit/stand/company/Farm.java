package fruit.stand.company;

import fruit.stand.people.Farmer;
import fruit.stand.products.Fruit;
import fruit.stand.products.Meat;
import fruit.stand.products.Product;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Farm {
    private Farmer farmer;
    private List<Fruit> fruits;
    private List<Meat> meats;

    public Farm() {
        farmer = new Farmer("Jake", 777);
        this.fruits = new ArrayList<>();
        this.meats = new ArrayList<>();
        addFruit("Apple", "Gala", 1.5, 20, "Red");
        addFruit("Apple", "Fuji", 2.5, 15, "Red");
        addFruit("Orange", "Blood", 1.75, 25, "Red-Orange");
        addFruit("Orange", "Cara Cara", 2, 23, "Orange");
        addFruit("Grape", "Concord", 1.75, 21, "Grape");
        addFruit("Grape", "Thompson", 2, 23, "Green");
        addMeat("Chicken", "Thigh", 5.75, 18, "raw");
        addMeat("Chicken", "Breast", 6, 20, "charred");
        addMeat("Steak", "Flank", 5.25, 18, "Well Done");
        addMeat("Steak", "Shaved", 7, 20, "Rare");
        addMeat("Pork", "Shoulder", 4.5, 16, "Medium Rare");
        addMeat("Pork", "Chop", 6.25, 17, "Medium Well");
    }

    private void addFruit(String name, String type, double cost, int amount, String color) {
        fruits.add(new Fruit(name, type, Date.from(Instant.now()), cost, amount, color));
    }

    private void addMeat(String name, String type, double cost, int amount, String cookLevel) {
        meats.add(new Meat(name, type, Date.from(Instant.now()), cost, amount, cookLevel));
    }

    public Fruit getFruit(int index) {
        return fruits.get(index);
    }

    public Meat getMeat(int index) {
        return meats.get(index);
    }

    protected List<Fruit> getFruits() {
        return fruits;
    }

    protected List<Meat> getMeats() {
        return meats;
    }

    public Farmer getFarmer() {
        return farmer;
    }
}
