package fruit.stand.products;

import fruit.stand.people.Farmer;
import fruit.stand.products.Fruit;
import fruit.stand.products.Meat;

import java.time.LocalDate;
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
        addFruit("Apple", "Gala", 2_50, "Red");
        addFruit("Apple", "Fuji", 1_50, "Red");
        addFruit("Orange", "Blood", 1_75, "Red-Orange");
        addFruit("Orange", "Cara Cara", 2_00, "Orange");
        addFruit("Grape", "Concord", 1_75, "Purple");
        addFruit("Grape", "Thompson", 2_00, "Green");
        addMeat("Chicken", "Thigh", 5_75, "raw");
        addMeat("Chicken", "Breast", 6_00, "charred");
        addMeat("Steak", "Flank", 5_25, "Well Done");
        addMeat("Steak", "Shaved", 7_00, "Rare");
        addMeat("Pork", "Shoulder", 4_50, "Medium Rare");
        addMeat("Pork", "Chop", 6_25, "Medium Well");
    }

    private void addFruit(String name, String type, int cost, String color) {
        fruits.add(new Fruit(name, type,
                LocalDate.of(2020, 8, (int) (Math.floor(Math.random() * 7) + 18)),
                cost, 1, color));
    }

    private void addMeat(String name, String type, int cost, String cookLevel) {
        meats.add(new Meat(name, type,
                LocalDate.of(2020, 8, (int) (Math.floor(Math.random() * 7) + 18)),
                cost, 1, cookLevel));
    }

    public Fruit getFruit(int index) {
        return fruits.get(index);
    }

    public Meat getMeat(int index) {
        return meats.get(index);
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void displayFruits() {
        for (Fruit fruit : fruits) {
            System.out.printf("Name: %s\tType: %s\tCost: %s\tColor: %s\n",
                    fruit.getName(), fruit.getType(), fruit.getCost(), fruit.getColor());
        }
    }

    public void displayMeats() {
        for (Meat meat : meats) {
            System.out.printf("Name: %s\tType: %s\tCost: %s\tCookLevel: %s\n",
                    meat.getName(), meat.getType(), meat.getCost(), meat.getCookLevel());
        }
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public Farmer getFarmer() {
        return farmer;
    }
}
