package fruit.stand.company.console;

import fruit.stand.company.Store;
import fruit.stand.products.Fruit;
import fruit.stand.products.Meat;
import fruit.stand.products.Product;

import java.awt.dnd.DragGestureEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private static Store store;
    private static final Scanner scan = new Scanner(System.in);
    private final static String[] MENU = new String[]{
            "(1) Add product to inventory",
            "(2) Throw away a product",
            "(3) List products available",
            "(4) Sell a product",
            "(5) Quit"
    };
    private final static String[] PRODUCT_TYPES = new String[]{
            "(1) Fruit",
            "(2) Meat"
    };

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void start(Store store) {
        welcome(store.getCashier().getName());
    }

    public static void handleMenuSelection() {
        displayOptions("What do you want to do?", MENU);
        int choice = getInt("Menu", 1, MENU.length);
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                throwAwayProduct();
                break;
            case 3:
                displayProduct();
                break;
            case 4:
                sellProduct();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private static void addProduct() {
        displayOptions("What kind of product?", PRODUCT_TYPES);
        int choice = getInt("Enter a number", 1, PRODUCT_TYPES.length);
        Product newProduct;
        switch (choice) {
            case 1:
//                newProduct = getFruitDetails();
                break;
            case 2:
//                newProduct = getDrinkDetails();
                break;
            default:
                System.out.println("");
                break;
        }
    }

    private static void throwAwayProduct() {

    }

    private static void displayProduct() {

    }

    private static void sellProduct() {

    }

    private static Fruit getFruitDetails() {
//        return new Fruit(
//                getString("DrinkName", true),
//                getInt(1,Integer.MAX_VALUE,"Price?"),
//                getString(),
//
//        )
    }

//    private static Drink getDrinkDetails() {
//    }

    public static int getInt(String prompt, int min, int max) {
        int option = min - 1;
        do {
            try {
                System.out.println(prompt);
                option = Integer.parseInt(scan.next());
            } catch (NumberFormatException nfe) {
                System.out.printf("Invalid input, enter integer between %s and %s\n", min, max);
            }
        } while (option < min || option > max);
        return option;
    }

    public static String getString(String prompt, boolean allowEmpty) {
        String input = null;

        do {
            input = scan.next();
            if (!allowEmpty && input.length() == 0) {
                System.out.println("Must enter something");
                continue;
            }
            break;
        }
        while (true);
        return input;
    }
}
