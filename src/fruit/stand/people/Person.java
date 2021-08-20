package fruit.stand.people;

import fruit.stand.Transaction;

public class Person {
    protected String name;
    protected double cash;

    public Person(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }

    private void setCash(double cash) {
        this.cash = cash;
    }

    public void pay(Transaction transaction) {
        if ((transaction.getProduct().getCost() * transaction.getAmount()) > cash) {
            return;
        }
        setCash(cash - transaction.getProduct().getCost());
    }
}
