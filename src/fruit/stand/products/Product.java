package fruit.stand.products;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    protected String name;
    protected String type; //specific is like gala or wing
    protected LocalDate expDate;
    protected double cost;
    protected int amount;

    public Product(String name, String type, LocalDate expDate, double cost, int amount) {
        this.name = name;
        this.type = type;
        this.expDate = expDate;
        this.cost = cost;
        this.amount = amount;
    }

    public LocalDate getExpDate() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", expDate=" + expDate +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }
}
