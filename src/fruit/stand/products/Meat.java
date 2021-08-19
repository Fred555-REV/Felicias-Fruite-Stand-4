package fruit.stand.products;

import java.util.Date;

public class Meat extends Product {
    private String cookLevel;   //raw,rare,wellDone

    public Meat(String name, String type, Date expDate, double cost, int amount, String cookLevel) {
        super(name, type, expDate, cost, amount);
        this.cookLevel = cookLevel;
    }

    @Override
    public String toString() {
        return "\nMeat{" +
                "name='" + name + '\'' +
                ",\ttype='" + type + '\'' +
                ",\tcookLevel='" + cookLevel + '\'' +
                ",\texpDate=" + expDate +
                ",\tcost=" + cost +
                ",\tamount=" + amount +
                '}';
    }
}
