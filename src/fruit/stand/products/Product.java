package fruit.stand.products;

import java.util.Date;

public class Product {
    protected String name;
    protected String type; //specific is like gala or wing
    protected Date expDate;
    protected double cost;
    protected int amount;

    public Product(String name, String type, Date expDate, double cost, int amount) {
        this.name = name;
        this.type = type;
        this.expDate = expDate;
        this.cost = cost;
        this.amount = amount;
    }

    public Date getExpDate() {
        return expDate;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
