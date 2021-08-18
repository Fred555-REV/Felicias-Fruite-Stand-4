package fruit.stand.products;

import java.util.Date;

public class Product {
    protected String name;
    protected String subtype; //specific is like gala or wing
    protected Date expDate;
    protected double cost;
    protected int amount;

    public Product(String name, String subtype, Date expDate, double cost, int amount) {
        this.name = name;
        this.subtype = subtype;
        this.expDate = expDate;
        this.cost = cost;
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getSubtype() {
        return subtype;
    }
}
