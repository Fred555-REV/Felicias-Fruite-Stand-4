package fruit.stand;

public class Person {
    private double cash;

    public double getCash() {
        return cash;
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
