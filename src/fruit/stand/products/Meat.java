package fruit.stand.products;

import java.time.LocalDate;
import java.util.Date;

public class Meat extends Product {
    private String cookLevel;   //raw,rare,wellDone

    protected Meat(String name, String type, LocalDate expDate, double cost, int amount, String cookLevel) {
        super(name, type, expDate, cost, amount);
        this.cookLevel = cookLevel;
    }

    public String getCookLevel() {
        return cookLevel;
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
