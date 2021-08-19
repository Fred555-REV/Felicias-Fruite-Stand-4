package fruit.stand;

import fruit.stand.products.Fruit;

import java.time.Instant;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("apple", "sub", Date.from(Instant.now()), 1, 1, "red");
        System.out.println(fruit);
        System.out.println(fruit.getAmount());
    }
}
