package fruit.stand.people;

import fruit.stand.company.Transaction;

public class Person {
    protected String name;
    protected double cash;

    public Person(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void pay(Transaction transaction) {
        if ((transaction.getProduct().getCost() * transaction.getAmount()) > cash) {
            return;
        }
        cash -= transaction.getProduct().getCost();
    }
}
