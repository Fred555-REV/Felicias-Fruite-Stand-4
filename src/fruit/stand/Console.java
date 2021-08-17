package fruit.stand;

import java.util.List;

public class Console {
    private Store store;
    private Cashier cashier;

    public Console(Store store, Cashier cashier) {
        this.store = store;
        this.cashier = cashier;
    }

    public void menu() {
        System.out.println("Welcome "+ cashier.getName());
        System.out.println("(1) Stock the store");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public Cashier getCashier() {
        return cashier;
    }
}
