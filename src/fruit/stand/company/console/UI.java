package fruit.stand.company.console;

import fruit.stand.company.Store;

import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void optionMenu() {
        System.out.println("What would you like to do?");
        System.out.println("(1) Order a product for the store.");
        System.out.println("(2) Take order from Customer");
        System.out.println("(3) Check for expired items.");
        System.out.println("(4) Handle pending transactions");
        System.out.println("(5) Take inventory of products");
        System.out.print("(6) Handle transactions automatically (toggle is ");
    }

    public void start(Store store) {
        welcome(store.getCashier().getName());
    }
}
