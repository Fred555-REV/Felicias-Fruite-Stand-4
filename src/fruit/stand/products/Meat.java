package fruit.stand.products;

import java.util.Date;

public class Meat extends Product {
    private String cookLevel;   //raw,rare,wellDone

    public Meat(String type, String subtype, Date expDate, double cost, int amount, String cookLevel) {
        super(type, subtype, expDate, cost, amount);
        this.cookLevel = cookLevel;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "\n\tcookLevel='" + cookLevel + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\ttype='" + type + '\'' +
                "\n\texpDate=" + expDate +
                "\n\tcost=" + cost +
                "\n\tamount=" + amount +
                "\n" + '}' + "\n";
    }
}
