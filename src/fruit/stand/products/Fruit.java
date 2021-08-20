package fruit.stand.products;

import java.time.LocalDate;

public class Fruit extends Product {
    //    private List<String> typeList;
    private String color;

    protected Fruit(String name, String subtype, LocalDate expDate, double cost, int amount, String color) {
        super(name, subtype, expDate, cost, amount);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\nFruit{" +
                "name='" + name + '\'' +
                ",\ttype='" + type + '\'' +
                ",\tcolor='" + color + '\'' +
                ",\texpDate=" + expDate +
                ",\tcost=" + cost +
                ",\tamount=" + amount +
                '}';
    }
}
