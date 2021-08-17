package fruit.stand;

public class Transaction {
    private double amount;
    private String from;
    private String to;
    private Product product;

    public Transaction(double amount, String from, String to, Product product) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", product=" + product +
                '}';
    }
}
