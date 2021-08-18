package fruit.stand.products;

import java.util.Date;

public class Product {
    private String type;    //general is like apple or chicken
    private String subtype; //specific is like gala or wing
    private Date expDate;
    private double cost;
    private int amount;

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }
}
