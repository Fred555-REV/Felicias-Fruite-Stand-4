package fruit.stand;

import fruit.stand.products.Fruit;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("apple", "sub", LocalDate.now(), 1, 1, "red");
        System.out.println(fruit);
        System.out.println(fruit.getAmount());
    }
}
