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

    public boolean pay(Transaction transaction) {
        if (transaction.getFrom().getName().equals(name) && transaction.getAmount() > cash) {
            return false;
        }
        setCash(cash - transaction.getAmount());
        return true;
    }
}
