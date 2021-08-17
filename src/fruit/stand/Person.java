package fruit.stand;

public class Person {
    private String name;
    private double cash;

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

    public boolean pay(double amount) {
        if (amount > cash) {
            return false;
        }
        setCash(cash - amount);
        return true;
    }
}
