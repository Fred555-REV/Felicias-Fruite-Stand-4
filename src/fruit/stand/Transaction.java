package fruit.stand;

import fruit.stand.people.Person;
import fruit.stand.products.Product;

public class Transaction {
    private double amount;
    private Person from;
    private Person to;
    private Product product;

    public Transaction(double amount, Person from, Person to, Product product) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    public Product getProduct() {
        return product;
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
