package fruit.stand;

import Util.Formatter;
import fruit.stand.company.console.UI;
import fruit.stand.products.Fruit;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        UI.getInt("number between 1-5",1,5);
        Formatter.test();

    }
}
